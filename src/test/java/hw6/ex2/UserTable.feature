Feature: JDI User Table Page

  Scenario: User Table Page Interface test

    Given I'm on HOME_PAGE_LINK
    And I login as user PITER_CHAILOVSKII
    When I click on Service button in Header
    And I click on User Table button in Service dropdown
    Then USER_TABLE_TITLE page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page

    And User table contains following values:
      | 1 | Roman            | Wolverine                         |
      | 2 | Sergey Ivan      | Spider Man                        |
      | 3 | Vladzimir        | Punisher                          |
      | 4 | Helen Bennett    | Captain America\nsome description |
      | 5 | Yoshi Tannamuri  | Cyclope\nsome description         |
      | 6 | Giovanni Rovelli | Hulk\nsome description            |

    When I select 'vip' checkbox for Sergey Ivan
    Then 1 log row has "Vip: condition changed to true" text in log section

    When I click on dropdown in column Type for user Roman
    Then droplist contains values
    |Admin|
    |User|
    |Manager|
