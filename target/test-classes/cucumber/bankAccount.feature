Feature: Bank Account Operations
  As a customer
  I want to deposit money in the bank account 

  Scenario Outline: deposit money in the bank account
    Given <username> has a bank account
    When <username> is valid
    	And deposit <value> is bigger than 0
    When <value> is bigger than 1000
    Then <username> give <credits>
    And set <username> as gold
    
    
    Examples:
    	|username|value|credits|
    	|"Marcel"|1000|100|