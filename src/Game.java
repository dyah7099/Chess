import java.io.*;


public class Game {
	private GameStatus status;
	
	
	private void displayFirstMessage()
	{
		String firstMessage = "Hello, welcome to Notches. Would you like to create a new game or load a saved game? Type create or load.";
		System.out.println(firstMessage);
	}
	
	private void displayHomeMessage()
	{
		
	}
	
	private String getInput() 
	{
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
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
		Stats stats1 = new Stats();
		
		player1.assignRandomName();
		player1.setGear(gear1);
		player1.setInventory(inventory1);
		player1.setStats(stats1);
		
		Shop shop1 = new Shop();
		GameStatus gamestatus1 = new GameStatus(player1, shop1);
	}
	
	public void Create()
	{
		Player player1 = new Player();
		player1.assignRandomName();
		
	}
	
	public void Load()
	{
		
	}
	
	public void Run()
	{
		displayFirstMessage();
		String response = getInput();
		if(response.compareTo("create")==0)
		{
			Create();
		}
		else
		{
			Load();
		}
	}
	
	
}
