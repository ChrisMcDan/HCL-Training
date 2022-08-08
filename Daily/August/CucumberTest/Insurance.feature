@tag
Feature: Insurance rates per customer

  Scenario Outline: 
    Given Customer <Customer> signs up
    When If customer age <Age> is greater than 18, apply discount <Discount>
    And If customer has no crashes <no_crashes>,apply discount <Discount>
    And If customers credit score <credit_score> is greater than 600,apply discount <Discount>
    Then Display     total discount

    Examples: 
      | Customer  | Age | no_crashes | credit_score | Discount |
      | "John"    |  16 | "True"     |          600 |        2 |
      | "Sam"     |  19 | "True"     |          900 |        2 |
      | "Peter"   |  21 | "False"    |          850 |        2 |
 