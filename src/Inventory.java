import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	private int maxItems;
	
	public void updateInventory(ArrayList<Item> boughtItems)
	{
		
	}
	
	public void updateInventory(Item item)
	{
		this.items.add(item);
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	public String toString()
	{
		String inventory = "";
		for(Item i : this.items)
		{
			inventory += "name: " + i.getName() + "\n";
		}
		
		return inventory;
		
	}
}
