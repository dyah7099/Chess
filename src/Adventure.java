import java.util.ArrayList;

public class Adventure {
	private int day;
	private AdventureResult adventureResult;
	
	public AdventureResult goAdventure()
	{
		System.out.println("Off to go adventure... \n");
		this.adventureResult = this.doAdventure();
		
		return this.adventureResult;
	}
	
	private AdventureResult doAdventure()
	{
		this.adventureResult = randomizeResult();
		
		//maybe write helper method for printing all of this out
		System.out.println("Day "+ this.day+ " of your adventure");
		System.out.println("On your adventure you have collected: ");
		System.out.println("loot: " + adventureResult.loot);
		System.out.println("coins: "+ adventureResult.coins);
		System.out.println("xp: "+ adventureResult.xp);
		
		
		//placeholder to get rid of error for method not returning anything yet
		return this.adventureResult;
	}
	
	public AdventureResult randomizeResult()
	{
		
		//HARDCODED FOR TESTING NEED TO ADD RANDOMIZATION
		AdventureResult adventureResult1 = new AdventureResult();
		ArrayList<Item> items1 = new ArrayList<Item>();
		Item item1 = new Item("Matches", 2, 1, false);
		items1.add(item1);
		adventureResult1.coins = 1;
		adventureResult1.xp = 2;
		adventureResult1.loot = items1;
		adventureResult1.death = false;
		
		//add randomization
		
		return adventureResult1;
		
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public void setDay(int _day)
	{
		this.day = _day;
	}
	
	public void incrementDay()
	{
		this.day++;
	}
	
	public AdventureResult getAdventureResult()
	{
		return this.adventureResult;
	}
}
