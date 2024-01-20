# Loan Customer Management Program (Assignment 10)

## Overview

This program simulates a Customer Management System for a bank's loan department. It is designed to handle customers in different categories: Large Enterprise (LE), Medium Enterprise (ME), and Small Enterprise (SE). The system utilizes queues for each category and loan officers to manage the loan application process. Additionally, a checkout queue is implemented for customers who have completed the loan process.

## Classes

### 1. Customer

- **Attributes:**
  - `custID` (int): Unique customer ID.
  - `category` (String): Customer category (LE, ME, or SE).

- **Methods:**
  - `getCustID()`: Returns the customer's ID.
  - `getCategory()`: Returns the customer's category.
  - `toString()`: Returns a string representation of the customer.

### 2. LoanOfficer

- **Attributes:**
  - `officerID` (int): Unique ID for the loan officer.
  - `currentCustomer` (Customer): Currently assigned customer.

- **Methods:**
  - `LoanOfficer(int id)`: Constructor to create a LoanOfficer object.
  - `getID()`: Returns the loan officer's ID.
  - `hasCustomer()`: Checks if the loan officer has an assigned customer.
  - `assignCustomer(Customer customer1)`: Assigns a customer to the loan officer.
  - `handleCustomer()`: Simulates handling a customer and returns the customer.
  - `toString()`: Returns a string representation of the loan officer.

### 3. CustomerManagement

- **Attributes:**
  - `LEQueue` (LinkedList<Customer>): Queue for Large Enterprise customers.
  - `MEQueue` (LinkedList<Customer>): Queue for Medium Enterprise customers.
  - `SEQueue` (LinkedList<Customer>): Queue for Small Enterprise customers.
  - `checkoutQueue` (LinkedList<Customer>): Queue for checked-out customers.
  - `officerList` (LoanOfficer[]): Array of LoanOfficer objects.

- **Methods:**
  - `CustomerManagement(int numOfLoanOfficers)`: Constructor to create a CustomerManagement object.
  - `addCustomer(int id, String category)`: Adds a customer to the appropriate queue.
  - `assignCustomerToLoanOfficer()`: Assigns a customer to a loan officer based on priority.
  - `releaseCustomerFromOfficer(int officerID)`: Releases a customer from a loan officer to the checkout queue.
  - `checkOutCustomer()`: Checks out a customer from the checkout queue.
  - `printQueues()`: Prints the contents of queues and loan officers.

## How to Run

1. Open the provided `Main.java` file.
2. Compile and run the program.
3. Follow the on-screen menu to interact with the Loan Customer Management System.

## Menu Options

- **A: Add Customer**
  - Adds a customer to the appropriate queue.

- **C: Check Out Customer**
  - Checks out a customer from the checkout queue.

- **L: List Customer Queues**
  - Displays the contents of queues and loan officers.

- **Q: Quit**
  - Exits the program.

- **R: Release Customer From Loan Officer**
  - Releases a customer from a loan officer.

- **S: Assign Customer To Loan Officer**
  - Assigns a customer to a loan officer.

- **?: Display Help**
  - Shows the menu options and their actions.

## Notes

- Customers are categorized as Large Enterprise (LE), Medium Enterprise (ME), or Small Enterprise (SE).
- Loan officers serve customers based on priority: LE > ME > SE.
- Customers are added to queues and processed by loan officers.
- Checked-out customers receive a complimentary gift.

Feel free to explore the functionality of the Loan Customer Management System through the provided menu options.
