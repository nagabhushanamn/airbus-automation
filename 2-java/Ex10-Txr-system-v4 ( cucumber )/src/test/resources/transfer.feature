Feature: Transfer system
  
  Transfer between accounts

  Scenario: valid Txr
    Given account with 1000 balance
    When transfer 500
    Then account must have 500 balance
