// Name: Sri Darahas Koneru.
// Description: LoanOfficer class represents a bank loan officer
//              that accept/handle and release customers.

public class LoanOfficer
{
   private int officerID;
   private Customer currentCustomer;

   //**************************************************
   //Constructor to initialize member variables
   //Initially no patient is assigned
   public LoanOfficer(int id)
   {
      this.officerID = id;
      currentCustomer = null;
   }

   //******************************************
   //an accessor method for the officer's ID
   public int getID()
   {
      return officerID;
   }

   //****************************************************************
   //method to determine if a loanOfficer currently has a customer by
   //checking the currentCustomer variable
// This method checks whether a loan officer has a customer assigned to them.
public boolean hasCustomer()
{
    // Check if the loan officer has a current customer assigned to them.
    if (currentCustomer != null) 
    {
        // If there is a current customer assigned to the loan officer, return true.
        return true;
    } else {
        // If there is no current customer assigned to the loan officer, return false.
        return false;
    }
}

   //************************************************************************
//This method assigns a customer to a loan officer, if the loan officer does not currently have a customer assigned to them.
//It returns true if the customer was successfully assigned, and false otherwise.
public boolean assignCustomer(Customer customer1)
{
 // If the loan officer currently has a customer assigned to them, do not assign the new customer.
 // Otherwise, assign the new customer to the loan officer.
 currentCustomer = hasCustomer() ? currentCustomer : customer1;

 // Return true if the customer was successfully assigned, and false otherwise.
 return !hasCustomer();
}


   //*********************************************
   public Customer handleCustomer()
   {
      //Add your own code
	   Customer handledCustomer = null;
	// Declare a variable to hold the customer that was previously assigned to the loan officer.
	   if (currentCustomer != null) { 
		// If the loan officer currently has a customer assigned to them, save a reference to that customer and set the loan officer's current customer to null.
	       handledCustomer = currentCustomer;
	       currentCustomer = null;
	   }
	// Return the customer that was previously assigned to the loan officer
	   return handledCustomer;
      //----
   }

   //********************************************
   //toString method returns a string containing
   public String toString()
   {
      String result = "\nOfficer ID: " + officerID;

      if (currentCustomer == null)
         result += " does not have any cutomers\n";
      else
         result += " is serving customer with id " + currentCustomer.getCustID() + "\n";

      return result;
   }
}