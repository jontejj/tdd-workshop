package se.noxfinans.tddworkshop.cucumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer
{
	int balance;
	List<Item> boughtItems = new ArrayList<>();
	boolean hasReciept;
	String name;

	public Customer(String name)
	{
		this.name = name;
	}

	public void buyItem(String item, Integer price)
	{
		boughtItems.add(new Item(item, price));
		balance -= price;
	}

	public void returns(String item)
	{
		Iterator<Item> items = boughtItems.iterator();
		while(items.hasNext())
		{
			Item i = items.next();
			if(i.getName().equals(item))
			{
				items.remove();
				balance += i.getPrice();
				break;
			}
		}
	}

	public void hasReceipt()
	{
		hasReciept = true;
	}
}
