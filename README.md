# ATM

You go to an ATM and wish to withdraw money. Write a program that, given any amount of money to withdraw, will give you the least amount of bills (Available bills: $1, $2, $5, $10, $20, $50, $100) and coins (0.01, 0.05, 0.10, 0.50).
 
- The program should start with specific quantities of available bills and coins.

- The user will enter any amount they wish to withdraw and the program should return the least number of bills and coins for that amount.

- During execution, the program should keep track of the available quantities of each bill and coin.

- In case there is not enough money on the ATM for the amount to be withdrawn, a customized Exception should be thrown.

ASSUMPTIONS:
- The available bills are $1, $2, $5, $10, $20, $50, $100.
- The available coins are 1c, 5c, 10c, 25c, 50c.
(OPTIONAL) Make the starting available quantities easily configurable.
(OPTIONAL) Write unitary tests to cover different scenarios.
(OPTIONAL) Expose the functionality through a REST API.
