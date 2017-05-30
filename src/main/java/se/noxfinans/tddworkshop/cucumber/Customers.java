package se.noxfinans.tddworkshop.cucumber;

import java.util.HashMap;
import java.util.Map;

public class Customers
{
	private Map<String, Customer> customers = new HashMap<>();

	Customer get(String name)
	{
		return customers.computeIfAbsent(name, Customer::new);
	}
}
