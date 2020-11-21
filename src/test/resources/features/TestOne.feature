Feature: Final project for QA2

  Scenario: make an unconfirmed purchase from 1a.lv
    Given open browser with address https://www.1a.lv
    And search for product Dators
    And filter products by brand Apple
    And choose any first filtered product
    And put the chosen product into basket
    And proceed to the checkout as unregistered user
    And choose pick up option in the office
    And fill in the userform with name=Lena, surname=Robot and phone=21234567
