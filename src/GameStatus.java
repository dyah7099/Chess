import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		System.out.print("\n");
		for(Item i : this.shop.getItems())
		{
			System.out.println(i.toString());
		}
		
		//add more here about buying/selling when appropriate
	}
	
	public void goToInventory()
	{
		for(Item i : this.player.getInventory().getItems())
		{
			System.out.println(i.toString());
		}
		
		//add more here about equipping items to gear and selling possibly?
	}
	
	public void goToAdventure()
	{
		Adventure adventure1 = new Adventure();
		this.adventure = adventure1;
		this.adventure.setDay(1);
		String response;
		do 
		{
			this.adventure.goAdventure();
			this.adventure.displayMessage();
			response = this.getInput();
			this.adventure.incrementDay();
		} while(response.compareTo("exit") != 0);
	}
	
	private void displayShopMessage()
	{
		
	}
	
	private void displayInventoryMessage()
	{
		
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
