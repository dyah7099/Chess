
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
	
	public void updateNotch()
	{
		while(this.xp>notch*10) {
			this.xp=this.xp-notch*10;
			notch+=1;
		}
	}
	
	//for when player buys/sells something
	public void updateStats(int price)
	{
		this.coins -= price;
	}
	
	//for after an adventure
	public void updateStats(int _coins, int _xp)
	{
		this.coins += _coins;
		this.xp += _xp;
	}
	
	public void reset() {
		this.coins=0;
		this.xp=0;
		this.notch=1;		
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
	
	public String toString()
	{
		return "Notch: " + this.notch + "\n"
						+ "XP: " + this.xp + "\n"
						+ "Coins: " + this.coins;
	}


}
