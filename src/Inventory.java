import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<Item>();
	private int maxItems;
	
	public void updateInventory(ArrayList<Item> boughtItems)
	{
		
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}

	public void clear() {
		items= new ArrayList<Item>();
		
	}
}
