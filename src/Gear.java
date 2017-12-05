import java.util.ArrayList;

public class Gear {
	private ArrayList<Item> items = new ArrayList<Item>();
	private int maxItems;
	
	public void updateGear(ArrayList<Item> equippedItems)
	{
		for(Item i : equippedItems)
		{
			items.add(i);
		}
	}
	
	public void resetGear() 
	{
		items= new ArrayList<Item>();
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	public void displayGear()
	{
		String gear = "";
		for(Item i : this.items)
		{
			gear += i.toString();
		}
		
		gear += "\nStrength: " + getStrength();
		
		System.out.println(gear);
	}
	
	public int getStrength()
	{
		ArrayList<Item> _items = this.items;
		int strength = 0;
		for(Item i : _items)
		{
			strength += i.getStrength();
		}
		
		return strength;
	}
	
	public String toString()
	{
		String final_ = "";
		for(Item i : this.items)
		{
			final_ += i.toString() + "\n";
		}
		
		return final_;
	}
}
