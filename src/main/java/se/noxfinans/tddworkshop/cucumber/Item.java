package se.noxfinans.tddworkshop.cucumber;

/**
 * Created by jonatanjonsson on 30/05/17.
 */
public class Item
{
	private final String name;
	private final int price;

	public Item(String name, Integer price)
	{
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public int getPrice()
	{
		return price;
	}
}
