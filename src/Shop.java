import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Shop {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Shop()
	{
		items.add(new Item("Hammer", 10, 2, false));
		items.add(new Item("Sheild", 15, 4, false));
		items.add(new Item("Boots", 7, 1, false));
		items.add(new Item("Dagger", 20, 3, false));
	}
	
	public void removeItems(Item[] boughtItems)
	{
		
	}
	
	public void addItems(Item[] soldItems)
	{
		
	}
	
	public void exit()
	{
		
	}
	
	public ArrayList<Item> getItems()
	{
		return this.items;
	}
}
