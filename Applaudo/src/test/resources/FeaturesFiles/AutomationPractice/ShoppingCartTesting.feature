#Author:
  #Drescription:
  #Navigate to the desired webpage
  #Add X items to the shopping cart
  #delete the items
  # Add items again
  # Proceed with the purchase
  # Search X items
  # Validate Store location
  #
  #

  #Pre-Requirements
#  Browser must run maximized

  @ShoppingCart
  Feature: Testing Shopping Cart(Positive)

    Background:
      
      Given I navigate to "http://automationpractice.com/index.php" Home Page


    @ShoppingCart
      Scenario: 01 - Creating a new user
        Given I need to create and Account with and email
          | Email                 |
          | ariel12314t@gmail.com |
        And I enter my personal information
          | Title | FirstName | LastName      | Email                 | Password    | Day | Month     | Year |
          | 2     | Ariel     | Hilario Minor | ariel12314t@gmail.com | Ariel12345! | 24  | September | 1991 |
        Then I enter my address information
        | FirstName | LastName      | Address           | City  | State   | PostalCode | Country       | Home phone     | Mobile phone   | AltEmail             |
        | Ariel     | Hilario Minor | 2250 NW 114th Ave | Miami | Florida | 33192      | United States | 1-829-597-9778 | 1-809-969-2603 | arielh.m@hotmail.com |


    @ShoppingCart
      Scenario: 02 - Placing and order
        Given I Sign in "ariel12314t@gmail.com" and "Ariel12345!"
        Then I move back to HomePage
        When I add "3" items to shopping cart
        And I move to shopping cart
        But I delete "3" item from shopping cart
        Then I move back to HomePage
        And I add "1" items to shopping cart
#        Then I proceed with order purchase

#
    @ShoppingCart
      Scenario: 03 - Navigate and verify Store Location
      Given I Scroll down until Store Location
      Then I verify Store Information

#    @ShoppingCart
#      Scenario: 03 - Search for items (Positive)
#
