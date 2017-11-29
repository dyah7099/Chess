
public class Player {
	private String name;
	private Inventory inventory;
	private Gear gear;
	private Stats stats;
	public final String[] names = {"Joffrey", "Tyrion", "Cersei", "Sansa", "Eddard"};
	
	
	
	public void updatePlayer(Item[] items)
	{
		
	}
	
	public void updatePlayer(Item[] items, int price)
	{
		
	}
	
	public void updatePlayer(Item[] loot, int coins, int experience)
	{
		
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
