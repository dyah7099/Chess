
public class Item {
	private String name;
	private int worth;
	private int rarity;
	private boolean isEquipped;
	
	public Item(String _name, int _worth, int _rarity, boolean _isEquipped)
	{
		this.name = _name;
		this.worth = _worth;
		this.rarity = _rarity;
		this.isEquipped = _isEquipped;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getWorth()
	{
		return this.worth;
	}
	
	public int getRarity()
	{
		return this.rarity;
	}
	
	public boolean getIsEquipped()
	{
		return this.isEquipped;
	}
}
