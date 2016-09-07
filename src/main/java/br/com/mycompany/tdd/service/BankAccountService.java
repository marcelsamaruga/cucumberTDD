/**
 * 
 */
package br.com.mycompany.tdd.service;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.mycompany.tdd.entity.BankAccount;
import br.com.mycompany.tdd.entity.Customer;
import br.com.mycompany.tdd.enums.EnumBankAccountClass;

/**
 * @author Marcel
 *
 */

@Named
@RequestScoped
public class BankAccountService {

	@Inject
	BankAccount bankAccount;
	
	/**
	 * @param value to add in the bank account
	 */
	public void deposit(BigDecimal value) {
		bankAccount.setCurrentValue( bankAccount.getCurrentValue().add(value) );
	}
	
	/**
	 * @param value to substract of the bank account
	 * @return the current value of the bankAccount
	 */
	public BigDecimal withdraw(BigDecimal value) {
		bankAccount.setCurrentValue( bankAccount.getCurrentValue().subtract(value) );
		return bankAccount.getCurrentValue();
	}

	/**
	 * @return the bankAccount
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * @param name
	 */
	public Customer hasBankAccountByCustomerName(String name) {
		if ( hasValidBankAccount() && StringUtils.isNotEmpty( bankAccount.getCustomer().getName() ) && 
			 bankAccount.getCustomer().getName().equalsIgnoreCase( name ) ) 
		{
			Customer customer = new Customer( nextCustomerVal() , name);
			return customer;
		}
		
		return null;
	}
	
	private Long nextCustomerVal() {
		if ( bankAccount != null) {
			if ( bankAccount.getCustomer() == null || bankAccount.getCustomer().getId() == null ) {
				return 1L;
			} else {
				return bankAccount.getCustomer().getId() + 1;
			}
		} else {
			return null;
		}
	}

	/**
	 * @return
	 */
	public Boolean hasValidBankAccount() {
		return bankAccount != null && bankAccount.getCustomer() != null ;
	}

	/**
	 * @param value
	 * @return
	 */
	public Boolean valueIsBiggerThanZero(BigDecimal value) {
		return value.compareTo(BigDecimal.ZERO) == 1;
	}

	/**
	 * @param value
	 * @return
	 */
	public Boolean isBiggerThanThousand(BigDecimal value) {
		return value.compareTo( new BigDecimal(1000) ) == 1 ;
	}

	/**
	 * @param username
	 */
	public void setCustomerAsGold(String username) {
		Customer customer = hasBankAccountByCustomerName(username);
	 	bankAccount.setAccountClass( EnumBankAccountClass.GOLD );
	}
	
}
