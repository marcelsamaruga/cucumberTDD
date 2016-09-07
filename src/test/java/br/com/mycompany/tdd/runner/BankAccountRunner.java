/**
 * 
 */
package br.com.mycompany.tdd.runner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.mycompany.tdd.entity.BankAccount;
import br.com.mycompany.tdd.entity.Customer;
import br.com.mycompany.tdd.service.BankAccountService;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Marcel
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions (
	format = {"pretty", "json:target/cucumber.json"},
	features = "classpath:cucumber/bankAccount.feature"
)
public class BankAccountRunner {


	BankAccount bankAccount;
	Customer customer;

	BankAccountService service;
	
	
	@Before
	public void setUp() throws Exception {
		customer    = new Customer(1L, "Marcel");
		bankAccount = new BankAccount(1L, "01010101", customer);
		//
		bankAccount.setCustomer(customer);
	}

	@Test
	public void customerAndBankAccountNotNull() {
		assertNotNull(customer);
		assertNotNull(bankAccount);
	}
	
	@Test
	public void customerValid() {
		assertThat( customer.getName() , equalTo("Marcel") );
		assertThat( customer.getId() , equalTo(1L) );
	}
	
	@Test
	public void deposit() {
		service.deposit( BigDecimal.TEN );
		//
		assertEquals( service.getBankAccount() , BigDecimal.TEN );
	}
	
	@Test
	public void withdraw() {
		service.withdraw( BigDecimal.TEN );
	}

}
