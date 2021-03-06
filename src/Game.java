import java.io.*;
import java.sql.*;
import java.util.ArrayList;


public class Game {
	private GameStatus status;


	private void displayFirstMessage()
	{
		String firstMessage = "Hello, welcome to Notches. Would you like to create a new game or load a saved game? Type create or load. \n";
		System.out.println(firstMessage);
	}

	private void displayHomeMessage()
	{
		String homeMessage = "Would you like to go on an Adventure, go to the Shop, go to your Inventory, or go to your Gear?? Type adventure, shop, inventory, gear, or type quit to exit. \n";
		System.out.println(homeMessage);
	}

	private void displayInitializationMessage()
	{
		//New Game has been created, initial player information is displayed
		System.out.println(" \nPlayer Name: " + this.status.getPlayer().getName());
		System.out.println("Notch: " + this.status.getPlayer().getStats().getNotch());
		System.out.println("xp: " + this.status.getPlayer().getStats().getXp());
		System.out.println("Coins: " + this.status.getPlayer().getStats().getCoins());
		System.out.println("Player Inventory and Gear are currently empty.\n");
	}

	private String getInput()
	{
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);
		//tries to read input will throw error if nothing is input
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

	private ArrayList<Item> loadItems()
	{
		ArrayList<Item> items = new ArrayList<Item>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Notches","user","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Items");
			while(rs.next()){
				items.add(new Item(rs.getString(2),rs.getInt(3),rs.getInt(4),false));
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return items;
	}

	public GameStatus getStatus()
	{
		return this.status;
	}

	public void initializeNewGame()
	{
		Player player1 = new Player();
		Gear gear1 = new Gear();
		Inventory inventory1 = new Inventory();
		ArrayList<Item> items = loadItems();
		Stats stats1 = new Stats(1, 0, 0);
		player1.assignRandomName();
		player1.setGear(gear1);
		player1.setInventory(inventory1);
		player1.setStats(stats1);

		Shop shop1 = new Shop();
		GameStatus gamestatus1 = new GameStatus(player1, shop1, items);
		//give the game is game status encompassing player (and all details), and shop, no adventure yet
		this.status = gamestatus1;
	}


	public void Create()
	{
		initializeNewGame();
		displayInitializationMessage();
	}

	public void Load()
	{
		//needs implementation of DB connection
	}


	public void Play()
	{
		String response;
		//loop allows player to repeatedly go between shop adventure and inventory etc.
		do {
			displayHomeMessage();
			response = getInput();

			if (response.compareTo("shop") == 0)
			{
				//go to shop
				this.status.goToShop();
			}
			else if (response.compareTo("adventure") == 0)
			{
				//go to adventure
				this.status.goToAdventure();
			}
			else if (response.compareTo("inventory") == 0)
			{
				//go to inventory
				this.status.goToInventory();
			}
			else if (response.compareTo("gear") == 0)
			{
				this.status.seeGear();
			}
			else
			{
				//wrong input
				String errorMessage = "I do not recognize that input";
				System.out.println(errorMessage);
			}
		} while(response.compareTo("quit") != 0);
	}

	public void Run()
	{
		displayFirstMessage();
		boolean properInput;
		do {
			String response = getInput();
			properInput = true;
			if(response.compareTo("create")==0)
			{
				Create();
			}
			else if(response.compareTo("load")==0)
			{
				Load();
			}
			else
			{
				String errorMessage = "I do not recognize that input";
				System.out.println(errorMessage);
				properInput = false;
			}
		} while(!properInput);

		Play();

	}

	public static void main(String[] args){
		//testing code, must change Game.loadItems to public to run
		Game g = new Game();
		ArrayList<Item> items = g.loadItems();
		for(int i = 0; i < items.size(); i++){
			System.out.println(items.get(i));
		}
	}

}
