import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Shop {
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Shop()
	{
		//hard coded for now just to have a few things in the shop
		//possibly write a helper method
		items.add(new Item("Hammer", 2, 2, false));
		items.add(new Item("Sheild", 2, 4, false));
		items.add(new Item("Boots", 2, 1, false));
		items.add(new Item("Dagger", 2, 3, false));
	}
	
	public void removeItems(ArrayList<Item> boughtItems)
	{
		for(Item i : boughtItems)
		{
			items.remove(i);
		}
	}
	
	public void removeItems(Item boughtItem)
	{
		this.items.remove(boughtItem);
	}
	
	public void addItems(ArrayList<Item> soldItems)
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
