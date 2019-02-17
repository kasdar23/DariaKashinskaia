Feature: JDI Different Elements Page

  Scenario: Different Elements Page Interface test

    Given I'm on HOME_PAGE_LINK
    Then The browser title is HOME_PAGE_TITLE
    And I login as user PITER_CHAILOVSKII
    Then 4 - pictures, 4 texts under them, 2 texts above are displayed
    Then I click on Service subcategory in the header and check that drop down contains
      | SUPPORT            |
      | DATES              |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |

    Then I click on Service subcategory in the left section and check that drop down contains
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |

    When I open through the header menu Service -> Different Elements Page
    Then 4 checkboxes, 4 radios, 1 dropdown, 2 buttons are displayed
    Then Right section is displayed
    Then Left section is displayed
    When I select element WATER
    Then Logs for element WATER is displayed and status is true
    When I select element WIND
    Then Logs for element WIND is displayed and status is true
    When I select material SELEN
    Then Log for SELEN is displayed
    When I select color YELLOW
    Then Log for YELLOW is displayed
    When I unselect element WATER
    Then Logs for element WATER is displayed and status is false
    When I unselect element WIND
    Then Logs for element WIND is displayed and status is false







