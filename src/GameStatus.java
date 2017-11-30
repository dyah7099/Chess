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
						if(i.getWorth() < this.player.getStats().getCoins())
						{
							boughtItems.add(i);
						}
						else
						{
							System.out.println("Not enought money to buy " + i.getName() + "\n");
						}
					}
				}
				
				this.shop.removeItems(boughtItems);
				this.player.updatePlayerBuy(boughtItems);
				
			}
			else
			{
				System.out.println("Enter a valid selection");
			}
		}while(response.compareTo("exit") != 0);
		
	}
	
	public void goToInventory()
	{
		String response;
		ArrayList<Item> equippedItems = new ArrayList<Item>();
		do
		{
			for(Item i : this.player.getInventory().getItems())
			{
				System.out.println(i.toString());
			}
			
			displayInventoryMessage();
			response = getInput();
			
			if(response.compareTo("equip") == 0)
			{
				displayEquipMessage();
				String response2 = getInput();
				for(Item i : this.player.getInventory().getItems())
				{
					if(response2.compareTo(i.getName()) == 0)
					{
						equippedItems.add(i);
					}	
				}
								
				this.player.updatePlayerEquip(equippedItems);
			}
			
		}while(response.compareTo("exit") != 0);
		
	}
	
	public void seeGear()
	{
		this.player.getGear().displayGear();
	}
	
	
	public void goToAdventure()
	{
		Adventure adventure1 = new Adventure();
		this.adventure = adventure1;
		this.adventure.setDay(1);
		String response;
		do 
		{

			AdventureResult adventureRes1 = this.adventure.goAdventure(player.getStats().getNotch());
			if(adventureRes1.death) {
				System.out.println("On day "+adventure.getDay()+ " you died of hemroids");
				this.player.resetPlayer();	
				response="exit";
			}else {
				this.player.updatePlayer(adventureRes1.loot, adventureRes1.coins, adventureRes1.xp);

				
				//checking to make sure player can be updated by adventure result
				System.out.println();
				System.out.println(this.player.getStats().toString());
				System.out.println();
				
				displayAdventureMessage();
				response = this.getInput();
			}	
			
			this.adventure.incrementDay();
		} while(response.compareTo("exit") != 0);
				
	}
	
	private void displayHomeMessage()
	{
		String homeMessage = "Would you like to go on an Adventure, go to the Shop, go to Inventory, or go to Gear? Type adventure, shop, inventory, or gear. \n";
		System.out.println(homeMessage);
	}
	
	private void displayShopMessage()
	{
		String shopMessage = "Would you like to buy an item? Type buy or exit. \n";
		System.out.println(shopMessage);
	}
	
	
	private void displayBuyMessage()
	{
		String buyMessage = "What item would you like to buy? Type the item name.\n";
		System.out.println(buyMessage);
	}
	
	private void displayInventoryMessage()
	{
		String inventoryMessage = "Would you like to equip an item or return home? Type equip or exit.";
		System.out.println(inventoryMessage);
	}
	
	private void displayEquipMessage()
	{
		String equipMessage = "Enter the name of the item that you would like to equip.";
		System.out.println(equipMessage);
	}
		
	private void displayAdventureMessage()
	{
		String adventureMessage = "Would you like to Continue on another day or return home? Type continue or exit."; 
		System.out.println(adventureMessage);
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
