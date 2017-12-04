
public class Item {
	private String name;
	private int worth;
	private int strength;
	private boolean isEquipped;
	
	public Item(String _name, int _worth, int _rarity, boolean _isEquipped)
	{
		this.name = _name;
		this.worth = _worth;
		this.strength = _rarity;
		this.isEquipped = _isEquipped;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String _name)
	{
		this.name = _name;
	}
	
	public int getWorth()
	{
		return this.worth;
	}
	
	public void setWorth(int _worth)
	{
		this.worth = _worth;
	}
	
	public int getStrength()
	{
		return this.strength;
	}
	
	public void setStrength(int _rarity)
	{
		this.strength = _rarity;
	}
	
	public boolean getIsEquipped()
	{
		return this.isEquipped;
	}
	
	public void setIsEquipped(boolean _isEquipped)
	{
		this.isEquipped = _isEquipped;
	}
	
	public String toString()
	{
		return  "Item Name: " + this.name + "\n" +
				"Worth: " + this.worth + "\n" +
				"Strength: " + this.strength + "\n" +
				"Equipped: " + this.isEquipped + "\n";
	}
}
