
public class Stats {
	private int notch;
	private int xp;
	private int coins;
	
	public Stats(int _notch, int _xp, int _coins)
	{
		this.notch = _notch;
		this.xp = _xp;
		this.coins = _coins;
	}
	
	public void updateStats(int price)
	{
		
	}
	
	public void updateStats(int coins, int experience)
	{
		
	}
	
	public int getNotch()
	{
		return this.notch;
	}
	
	public int getXp()
	{
		return this.xp;
	}
	
	public int getCoins()
	{
		return this.coins;
	}
}
