import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameStatus {
	private Player player;
	private Adventure adventure;
	private Shop shop;
	private ArrayList<Item> gameItems;

	public GameStatus(Player _player, Shop _shop, ArrayList<Item> items)
	{
		this.player = _player;
		this.shop = _shop;
		this.gameItems = items;
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
			else if(response.compareTo("sell") == 0)
			{
				displaySellMessage();
				String response3 = getInput();
				for(Item i : this.player.getInventory().getItems())
				{
					if(response3.compareTo(i.getName()) == 0)
					{
						player.updatePlayerSell(i);
						shop.addItems(i);
						break;
					}
				}
			}

		}while(response.compareTo("exit") != 0);

	}

	public void seeGear()
	{
		this.player.getGear().displayGear();
	}


	public void goToAdventure()
	{
		Adventure adventure1 = new Adventure(gameItems);
		this.adventure = adventure1;
		String response;
		do
		{

			AdventureResult adventureRes1 = this.adventure.goAdventure(player.getStats().getNotch(), this.player.getGear().getStrength());
			if(adventureRes1.death) {
				System.out.println("On day "+ adventure.getDay() + adventure.randomizeDeath());
				System.out.println("Your character has been reset. \n");
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
		player.updateNotch();
		System.out.println("You are now at notch "+ this.player.getStats().getNotch());
	}

	private void displayHomeMessage()
	{
		String homeMessage = "Would you like to go on an Adventure, go to the Shop, go to Inventory, or go to Gear? Type adventure, shop, inventory, or gear. \n";
		System.out.println(homeMessage);
	}

	private void displayShopMessage()
	{
		String shopMessage = "You have "+this.player.getStats().getCoins()+" coins\nWould you like to buy an item? Type buy or exit. \n";
		System.out.println(shopMessage);
	}


	private void displayBuyMessage()
	{
		String buyMessage = "\nWhat item would you like to buy? Type the item name.\n";
		System.out.println(buyMessage);
	}

	private void displayInventoryMessage()
	{
		String inventoryMessage = "\nWould you like to equip an item, sell an item, or return home? Type equip, sell, or exit.\n";
		System.out.println(inventoryMessage);
	}

	private void displayEquipMessage()
	{
		String equipMessage = "\nEnter the name of the item that you would like to equip.\n";
		System.out.println(equipMessage);
	}

	private void displaySellMessage()
	{
		String sellMessage = "\nEnter the name of the item that you would like to sell.\n";
		System.out.println(sellMessage);
	}

	private void displayAdventureMessage()
	{
		String adventureMessage = "\nWould you like to Continue on another day or return home? Type continue or exit.\n";
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
