import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	//removing when adding to gear
	public void updateInventory(ArrayList<Item> equippedItems)
	{
		for(Item i : equippedItems)
		{
			items.remove(i);
		}
	}
	
	//adding to inventory when buying
	public void updateInventory(Item item)
	{
		this.items.add(item);
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}

	public void clear() {
		items= new ArrayList<Item>();
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
