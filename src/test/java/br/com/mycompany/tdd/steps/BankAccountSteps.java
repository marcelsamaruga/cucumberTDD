/**
 * 
 */
package br.com.mycompany.tdd.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import br.com.mycompany.tdd.entity.BankAccount;
import br.com.mycompany.tdd.entity.Customer;
import br.com.mycompany.tdd.service.BankAccountService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Marcel
 *
 */
public class BankAccountSteps {

	private BankAccount bankAccount;
	private BankAccountService service;
	
	@Before
    public void setUp() {
		bankAccount = new BankAccount();
		service = new BankAccountService();
    }
	
	/*
	Scenario Outline: deposit money in the bank account
    Given "Marcel" has a bank account
    When "Marcel" is valid
    And deposit 1000 is bigger than 0
    When 1000 is bigger than 1000
    Then "Marcel" give 100
    And set "Marcel" as gold
	 * */
	

	@Given("^\"([^\"]*)\" has a bank account$")
	public void has_a_bank_account(String name) throws Throwable {
		Customer hasCustomer  = service.hasBankAccountByCustomerName( name );
		//
		assertNotNull( hasCustomer );
	}

	@When("^\"([^\"]*)\" is valid$")
	public void is_valid() throws Throwable {
	    Boolean hasBankAccount = service.hasValidBankAccount();
		//
		assertTrue( hasBankAccount );
	}

	@When("^deposit (\\d+) is bigger than (\\d+)$")
	public void deposit_is_bigger_than(BigDecimal value, BigDecimal compare) throws Throwable {
	    Boolean valueIsBiggerThanZero = service.valueIsBiggerThanZero( value );
		//
		assertTrue( valueIsBiggerThanZero );
	}

	@When("^(\\d+) is bigger than (\\d+)$")
	public void is_bigger_than(BigDecimal value, BigDecimal thousand) throws Throwable {
	    Boolean isBiggerThanThousand = service.isBiggerThanThousand( value );
	    //
	    assertTrue( isBiggerThanThousand );
	}

	@Then("^\"([^\"]*)\" give (\\d+)$")
	public void give(BigDecimal value) throws Throwable {
	    service.getBankAccount().setCurrentValue( value );
	    BigDecimal valueReturned = service.getBankAccount().getCurrentValue();
	    //
	    assertEquals( value , valueReturned );
	}

	@Then("^set \"([^\"]*)\" as gold$")
	public void set_as_gold(String username) throws Throwable {
	    service.setCustomerAsGold( username );
	}


	
}
