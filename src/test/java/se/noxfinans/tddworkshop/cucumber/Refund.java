package se.noxfinans.tddworkshop.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jonatanjonsson on 30/05/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
public class Refund implements En
{
	public Refund()
	{
		Given("^Jeff has bought a microwave for \\$(\\d+)$", (Integer amount) ->
		{
			System.out.format("Amount: %n\n", amount);
		});
		Given("^he has a receipt$", () ->
		{
			System.out.format("Has Receipt\n");
		});
		When("^he returns the microwave$", () ->
		{
			System.out.format("microwave returned\n");
		});

		Then("^Jeff should be refunded \\$(\\d+)$", (Integer amount) ->
		{
			System.out.format("Amount: %n\n", amount);
		});
	}
}
