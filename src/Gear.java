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
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
	
	public String toString()
	{
		String final_ = "";
		for(Item i : this.items)
		{
			final_ += i.getName() + "\n";
		}
		
		return final_;
	}
}
