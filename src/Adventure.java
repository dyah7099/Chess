import java.util.ArrayList;

public class Adventure {
	private int day;
	private AdventureResult adventureResult;
	
	public AdventureResult goAdventure(int notch)
	{
		System.out.println(" \nOff to go adventure... \n");
		this.adventureResult = this.doAdventure(notch);
		
		return this.adventureResult;
	}
	
	private AdventureResult doAdventure(int notch)
	{
		this.adventureResult = randomizeResult(notch);
		
		//maybe write helper method for printing all of this out
		if(!adventureResult.death) {
			System.out.println("Day "+ this.day+ " of your adventure");
			System.out.println("On your adventure you have collected: ");
			System.out.println("loot: " + adventureResult.loot);
			System.out.println("coins: "+ adventureResult.coins);
			System.out.println("xp: "+ adventureResult.xp);
		}
		
		return this.adventureResult;
	}
	
	public AdventureResult randomizeResult(int notch)
	{
		
		//HARDCODED FOR TESTING NEED TO ADD RANDOMIZATION
		AdventureResult adventureResult1 = new AdventureResult();
		ArrayList<Item> items1 = new ArrayList<Item>();
		Item item1 = new Item("Matches", 2, 1, false);
		items1.add(item1);
		adventureResult1.coins = 1 + (int) Math.random()*this.day/4;;
		adventureResult1.xp = (int) ((int)2 + Math.random()*this.day/2);
		adventureResult1.loot = items1;
		adventureResult1.death = Math.random()+(this.day-notch*2)/10>.9 ? true : false;
		
		//add randomization of items
		
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
