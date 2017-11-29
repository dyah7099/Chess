
public class Adventure {
	private int day;
	private AdventureResult adventureResult;
	
	public AdventureResult goAdventure()
	{
		//this.day=0;
		adventureResult= new AdventureResult();
		System.out.println("Off to go adventure");
		this.doAdventure();
		
		
		return this.adventureResult;
	}
	
	private AdventureResult doAdventure()
	{
		System.out.println("Day "+ this.day+ " of your adventure");
		System.out.println("On your adventure you have collected: ");
		System.out.println("loot: " + adventureResult.loot);
		System.out.println("coins: "+ adventureResult.coins);
		System.out.println("xp: "+ adventureResult.xp);
		
		
		//placeholder to get rid of error for method not returning anything yet
		return this.adventureResult;
	}
	
	public void displayMessage()
	{
		System.out.println("Would you like to Continue on another day or Return home? Type continue or exit.");
	}
	
	/*public AdventureResult randomizeResult()
	{
		//
	}*/
	
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
