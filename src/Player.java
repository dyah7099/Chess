import java.util.ArrayList;

public class Player {
	private String name;
	private Inventory inventory;
	private Gear gear;
	private Stats stats;
	public final String[] names = {"Joffrey", "Tyrion", "Cersei", "Sansa", "Eddard"};
	
	public void resetPlayer()
	{
		this.inventory.clear();
		stats.reset();
	}
	
	
	public void updatePlayer(ArrayList<Item> items)
	{
		for(Item i : items)
		{
			this.inventory.getItems().add(i);
		}
	}
	
	public void updatePlayerBuy(ArrayList<Item> items)
	{
		//increment or decrement items from inventory and according price from stats
		for(Item i : items)
		{
			this.inventory.updateInventory(i);
			this.stats.updateStats(i.getWorth());
		}
		
	}
	
	public void updatePlayerEquip(ArrayList<Item> equippedItems)
	{
		this.inventory.updateInventory(equippedItems);
		this.gear.updateGear(equippedItems);
	}
	
	public void updatePlayer(ArrayList<Item> loot, int coins, int experience)
	{
		//update stats with coins and xp
		this.stats.updateStats(coins, experience);
		//update inventory with loot
		this.updatePlayer(loot);
	}
	
	public void assignRandomName()
	{
		
		int rando = (int) (Math.random()* (names.length));
		this.name = names[rando];
	}
	
	public String getName()
	{
		return this.name;
	}
	public Inventory getInventory()
	{
		return this.inventory;
	}
	
	public void setInventory(Inventory _inventory)
	{
		this.inventory = _inventory;
	}
	
	public Gear getGear()
	{
		return this.gear;
	}
	
	public void setGear(Gear _gear)
	{
		this.gear = _gear;
	}
	
	public Stats getStats()
	{
		return this.stats;
	}
	
	public void setStats(Stats _stats)
	{
		this.stats = _stats;
	}
}
