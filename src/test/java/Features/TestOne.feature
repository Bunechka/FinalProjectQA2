@FinalTest
  Feature: Final project for QA2

    @TestOne
    Scenario: make an unconfirmed purchase from 1a.lv
      Given open browser
      Then open https://www.1a.lv
      And search for product Dators
      And filter products by brand Apple
      And choose any first filtered product
      And put the chosen product into basket
      And proceed to the checkout as unregistered user
      And choose option Preces saņemšana klientu centrā
      And tick the K Senukai OZOLS
      And enter buyer vārds
      And enter buyer uzvārds
      And enter buyer tālruņa numurs
      And press Submit order
