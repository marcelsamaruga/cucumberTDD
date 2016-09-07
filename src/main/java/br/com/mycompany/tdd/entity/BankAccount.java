/**
 * 
 */
package br.com.mycompany.tdd.entity;

import java.math.BigDecimal;

import br.com.mycompany.tdd.enums.EnumBankAccountClass;

/**
 * @author Marcel
 *
 */
public class BankAccount {

	private Long id;
	private String accountNumber;
	private Customer customer;
	private BigDecimal currentValue;
	private EnumBankAccountClass accountClass;
	
	public BankAccount(){}
	
	/**
	 * @param l
	 * @param string
	 * @param customer2
	 */
	public BankAccount(Long id, String accountNumber, Customer customer) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.customer = customer;
		//
		this.currentValue = BigDecimal.ZERO;
		this.accountClass = EnumBankAccountClass.STANDART;
	}
	/**
	 * @return the currentValue
	 */
	public BigDecimal getCurrentValue() {
		return currentValue;
	}
	/**
	 * @param currentValue the currentValue to set
	 */
	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the accountClass
	 */
	public EnumBankAccountClass getAccountClass() {
		return accountClass;
	}
	/**
	 * @param accountClass the accountClass to set
	 */
	public void setAccountClass(EnumBankAccountClass accountClass) {
		this.accountClass = accountClass;
	}
	
	
	
}
