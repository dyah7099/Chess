import java.util.ArrayList;

public class Adventure {
	private int day;
	private AdventureResult adventureResult;
	private ArrayList<Item> gameItems;
	
	public Adventure(ArrayList<Item> items) {
		this.gameItems = items;
		this.setDay(1);
	}
	
	public AdventureResult goAdventure(int notch, int strength)
	{
		System.out.println(" \nOff to go adventure... \n");
		this.adventureResult = this.doAdventure(notch, strength);

		return this.adventureResult;
	}

	private AdventureResult doAdventure(int notch, int strength)
	{
		this.adventureResult = randomizeResult(notch, strength);

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

	private ArrayList<Item> randomLoot(int notch){

		ArrayList<Item> actualLoot = new ArrayList<Item>();
		for(int i = 0; i < gameItems.size(); i++){
			Item currentItem = gameItems.get(i);
			int weight = Math.abs(currentItem.getStrength() - notch/4) + 5;
			for(int j = 0; j < 10*(notch%4); j++){
				if (Math.random() < 1.0/((double)weight*20)){
					actualLoot.add(currentItem);
				}
			}
		}
		return actualLoot;
	}

	public AdventureResult randomizeResult(int notch, int strength)
	{

		//HARDCODED FOR TESTING NEED TO ADD RANDOMIZATION
		AdventureResult adventureResult1 = new AdventureResult();
		ArrayList<Item> items1 = randomLoot(notch);
		adventureResult1.coins = (int)(3* Math.random() + 2) * this.day/4; //2-5 coins per 4 days
		adventureResult1.xp = (int)(2 * Math.random() + 2) * this.day/4; //2-3 xp per 2 days
		adventureResult1.loot = items1;
		adventureResult1.death = Math.random()>Math.pow(.93, (this.day/(notch*2+strength))) ? true : false;

		//add randomization of items

		return adventureResult1;

	}

	public String randomizeDeath()
	{
		ArrayList<String> deaths = new ArrayList<String>();
		deaths.add(" you died of hemorrhoids");
		deaths.add(" you got attacked by a bear and died");
		deaths.add(" you stubbed your toe, contracted gangrene, and died.");
		deaths.add(" you were kicked by an angry donkey and died.");
		deaths.add(" you ate a poison berry, threw up and became so dehydrated that you died.");

		int randomIndex = (int) ((Math.random() * deaths.size()));

		return deaths.get(randomIndex);
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
