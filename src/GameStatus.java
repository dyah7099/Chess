import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameStatus {
	private Player player;
	private Adventure adventure;
	private Shop shop;
	
	public GameStatus(Player _player, Shop _shop)
	{
		this.player = _player;
		this.shop = _shop;
	}
	
	public void printItems()
	{
		
	}
	
	public void goToShop()
	{
		String response;
		String response2;
		ArrayList<Item> boughtItems = new ArrayList<Item>();
		
		//handles buying
		do
		{
			boughtItems.removeAll(boughtItems);
			System.out.print("\n");
			for(Item i : this.shop.getItems())
			{
				System.out.println(i.toString());
			}
			
			displayShopMessage();
			response = getInput();
			
			if(response.compareTo("buy") == 0)
			{
				displayBuyMessage();
				response2 = getInput();
				
				for(Item i : this.shop.getItems() )
				{
					if(response2.compareTo(i.getName()) == 0)
					{
						boughtItems.add(i);
						//this.shop.removeItems(i);
						//this.player.updatePlayer(i, i.getWorth());
					}
				}
				
				this.shop.removeItems(boughtItems);
				this.player.updatePlayerBuy(boughtItems);
				
				
				System.out.println(this.player.getInventory().toString());
				//System.out.println(this.player.getInventory().toString());
			}
		}while(response.compareTo("exit") != 0);
		
	}
	
	public void goToInventory()
	{
		for(Item i : this.player.getInventory().getItems())
		{
			System.out.println(i.toString());
		}
		
		//add more here about equipping items to gear and selling possibly
	}
	
	public void goToAdventure()
	{
		Adventure adventure1 = new Adventure();
		this.adventure = adventure1;
		this.adventure.setDay(1);
		String response;
		do 
		{
			AdventureResult adventureRes1 = this.adventure.goAdventure();
			this.player.updatePlayer(adventureRes1.loot, adventureRes1.coins, adventureRes1.xp);
			
			//checking to make sure player can be updated by adventure result
			System.out.println("\nCurrent Stats:");
			System.out.println(this.player.getStats().toString());
			System.out.println();
			
			displayAdventureMessage();
			response = this.getInput();
				
		
			this.adventure.incrementDay();
		} while(response.compareTo("exit") != 0);
				
	}
	
	private void displayHomeMessage()
	{
		String homeMessage = "Would you like to go on an Adventure, go to the Shop, or go to your Inventory? Type adventure, shop, or inventory. \n";
		System.out.println(homeMessage);
	}
	
	private void displayShopMessage()
	{
		String shopMessage = "Would you like to buy an item? Type buy or exit.";
		System.out.println(shopMessage);
	}
	
	private void displayBuyMessage()
	{
		String buyMessage = "What item would you like to buy? Type the item name.";
		System.out.println(buyMessage);
	}
	
	private void displayInventoryMessage()
	{
		
	}
	
	private void displayAdventureMessage()
	{
		System.out.println("Would you like to Continue on another day or Return home? Type continue or exit.");
	}
	
	private String getInput()
	{
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);
		//tries to read input will throw error if nothing is input
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public void setPlayer(Player _player)
	{
		this.player = _player;
	}
	
	public Adventure getAdventure()
	{
		return this.adventure;
	}
	
	public Shop getShop()
	{
		return this.shop;
	}
}
