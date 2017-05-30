package se.noxfinans.tddworkshop.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, features = {"refund"})
public class Refund implements En
{
	/**
	 * Mostly because of https://groups.google.com/forum/#!topic/pitusers/bx4t1vMdKBg
	 */
	@Rule
  	public Timeout globalTimeout= new Timeout(20, TimeUnit.SECONDS);

	private Customers customers = new Customers();
	private String lastCustomer;
	public Refund()
	{
		Given("^([A-Za-z]*) has bought a ([a-z]*) for \\$(\\d+)$", (String customer, String item, Integer price) ->
		{
			customers.get(customer).buyItem(item, price);
			lastCustomer = customer;
		});
		Given("^he has a receipt$", () ->
		{
			customers.get(lastCustomer).hasReceipt();
		});
		When("^he returns the ([a-z]*)$", (String item) ->
		{
			customers.get(lastCustomer).returns(item);
		});

		Then("^([A-Za-z]*) should be refunded \\$(\\d+)$", (String customer, Integer amount) ->
		{
			assertThat(customers.get(customer).balance).isEqualTo(0);
		});
	}
}
