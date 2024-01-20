// Name: Sri Darahas Koneru
// Description: This program manages customer queues, assigns customer to loan officer,
//              process and release them, etc.

import java.util.LinkedList;

public class CustomerManagement
{
   private LinkedList<Customer> LEQueue;
   private LinkedList<Customer> MEQueue;
   private LinkedList<Customer> SEQueue;

   private LinkedList<Customer> checkoutQueue;

   private LoanOfficer[] officerList;

   //**********************************************
   //Constructor
   public CustomerManagement(int numOfLoanOfficers)
   {
      LEQueue = new LinkedList<Customer>();
      MEQueue = new LinkedList<Customer>();
      SEQueue = new LinkedList<Customer>();
      checkoutQueue = new LinkedList<Customer>();

      //creating LoanOfficer objects
      officerList = new LoanOfficer[numOfLoanOfficers];
      for (int i=0; i< officerList.length; i++)
      {
         officerList[i] = new LoanOfficer(i);
      }
   }

   //*******************************************************************
   //add a customer to the corresponding queue based on its category
   //return true if added to a queue successfully; otherwise return false
   boolean addCustomer(int id, String category)
   {
      //Add your own code
	   switch (category) {
	    case "LE":
	        // Create a new Customer object with the given ID and category
	        Customer customer1 = new Customer(id, category);
	        // Add the customer to the low priority queue
	        LEQueue.add(customer1);
	        // Return true to indicate that the customer was successfully added to the queue
	        return true;
	    case "ME":
	        // Create a new Customer object with the given ID and category
	        Customer customer2 = new Customer(id, category);
	        // Add the customer to the medium priority queue
	        MEQueue.add(customer2);
	        // Return true to indicate that the customer was successfully added to the queue
	        return true;
	    case "SE":
	        // Create a new Customer object with the given ID and category
	        Customer customer3 = new Customer(id, category);
	        // Add the customer to the high priority queue
	        SEQueue.add(customer3);
	        // Return true to indicate that the customer was successfully added to the queue
	        return true;
	    default:
	        // Return false to indicate that the customer was not added to the queue
	        return false;
	}
      //----
   }

   //*******************************************************************
   //assign a customer to a loan officer with large enterprise (LE) queues
   //going first; return null if there are no customers in the queues or if
   //there are no loan officer are available
// This method assigns a customer to a loan officer, based on the customer's priority level and 
// the availability of loan officers. It returns the customer that was assigned to the loan officer.
public Customer assignCustomerToLoanOfficer() {
    // Initialize variables to keep track of the loan officer and customer assignments
    int i = 0; // Counter for the loan officer list
    boolean officerFound = false; // Flag to indicate whether an available loan officer has been found
    Customer customer = null; // The customer that will be assigned to a loan officer
    
    // Loop through the loan officer list until an available loan officer is found or all loan 
    // officers have been checked.
    do {
        // Check if the current loan officer has no assigned customer
        if (officerList[i].hasCustomer() == false) {
            // If there are low-priority customers waiting in the queue, assign the first one to 
            // the current loan officer and update the officerFound flag.
            if (LEQueue.peek() != null) {
                customer = LEQueue.poll();
                officerList[i].assignCustomer(customer);
                officerFound = true;
            } 
            // If there are no low-priority customers waiting but there are medium-priority 
            // customers waiting, assign the first one to the current loan officer and update the 
            // officerFound flag.
            else if (MEQueue.peek() != null) {
                customer = MEQueue.poll();
                officerList[i].assignCustomer(customer);
                officerFound = true;
            } 
            // If there are no low- or medium-priority customers waiting but there are high-priority 
            // customers waiting, assign the first one to the current loan officer and update the 
            // officerFound flag.
            else if (SEQueue.peek() != null) {
                customer = SEQueue.poll();
                officerList[i].assignCustomer(customer);
                officerFound = true;
            }
        }
        // Move on to the next loan officer if the current one has a customer assigned already.
        i++;
    } while (i < officerList.length && !officerFound); // Continue looping until all loan officers have been checked or an available loan officer is found.
    
    // Return the customer that was assigned to the loan officer, if any.
    return customer;
}


   //***************************************************************
   //check if officer with the officerID has a customer, and release
   //that customer if they do. Then add that customer to checkout queue
   //and return the Customer object; otherwise return null
   
      //Add your own code
	   Customer releaseCustomerFromOfficer(int officerID)
	   {
	       if (!officerList[officerID].hasCustomer()) {
	           // If the officer doesn't have a customer assigned, return null
	           return null;
	       }

	       // Otherwise, get the customer from the officer and add them to the checkout queue
	       Customer customer = officerList[officerID].handleCustomer();
	       checkoutQueue.offer(customer);
	       return customer;
	   }
      //----
   

   //**************************************************************
   //remove the first Customer from the checkoutQueue and return it;
   //otherwise the method return null.
   
      //Add your own code
	   public Customer checkoutCustomer() {
   //If the checkOutQueue is not empty this method removes the next Customer from the queue head and returns it.
		    return (checkoutQueue.peek() != null) ? checkoutQueue.poll() : null;
		}
      //----
   

   //************************************************
   //The printQueue prints out the content
   //of the queues and the array of loan officers
   public void printQueues()
   {
      System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
      System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
      System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
      for (int i = 0; i < officerList.length; i++)
      {
         System.out.print(officerList[i].toString());
      }
      System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
   }
}