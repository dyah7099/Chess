
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
	}
	
	private void displayShopMessage()
	{
		
	}
	
	private void displayInventoryMessage()
	{
		
	}
	
	private void getInput()
	{
		
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
