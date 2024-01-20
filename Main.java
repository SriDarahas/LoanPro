// Name: Sri Darahas Koneru
// Description: the code gives a command line interface for customer management system with various functionalities
 //adding customers, assigning them to loan officers, and checking customers.

 import java.io.*;

 public class Main
 {
     public static void main (String[] args) throws IOException
     {
         char input1;
         String line = new String();
 
         printMenu();
 
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader stdin = new BufferedReader(isr);
         boolean setUpOfficers = false;
         CustomerManagement management1 = null;
 
         //The following part is to get a valid number of available loan officers from a user
         //in order to instantiate an object of CustomerManagement class
         do
         {
             System.out.print("Please specify how many loan officer will be available: ");
             try
             {
                 int numOfficers = Integer.parseInt(stdin.readLine().trim());
 
                 if (numOfficers > 0 )
                 {
                     //Create a patient management object
                     management1 = new CustomerManagement(numOfficers);
                     setUpOfficers = true;
                 }
                 else
                 {
                     System.out.print("\nPlease enter a positive integer");
                 }
             }
             catch(NumberFormatException ex)
             {
                 System.out.print("\nPlease enter a valid number");
             }
         } while (setUpOfficers == false);
 
         do  // will ask for user input
         {
             System.out.print("\nWhat action would you like to perform:");
             line = stdin.readLine();
             input1 = line.charAt(0);
             input1 = Character.toUpperCase(input1);
 
             if (line.length() == 1)
             {
                 // matches one of the case statements
                 switch (input1)
                 {
                     case 'A':   //Add a Customer
                         try
                         {
                             System.out.print("\nPlease enter the cusomter ID to add: ");
                             int id = Integer.parseInt(stdin.readLine().trim());
 
                             System.out.print("\nPlease specify the category of the customer: ");
                             String category1 = stdin.readLine().trim();
 
                             boolean added = management1.addCustomer(id, category1);
                             if (added)
                             {
                                 System.out.print("\nThe customer with id: " + id + " and category: " + category1
                                         + " is added\n");
                             }
                             else
                             {
                                 System.out.print("\nThe customer with id: " + id + " and category: " + category1
                                         + " is NOT added\n");
                             }
 
                         }
                         catch(NumberFormatException ex)
                         {
                             System.out.print("\nPlease enter a valid number");
                         }
                         break;
                     case 'C':   //check Out a Customer
                         Customer customer1 = management1.checkoutCustomer();
 
                         if (customer1 == null)
                         {
                             System.out.print("\nNo customer was checked out"+"\n");
                         }
                         else
                         {
                             System.out.print("\nCustomer " + customer1.toString() + " was checked out\n");
                         }
                         break;
                     case 'L':   //List queues
                         management1.printQueues();
                         break;
                     case 'Q':   //Quit
                         break;
                     case 'R':  //Release Customer From the relevant loan officer
                         try
                         {
                             System.out.print("\nWhich loan officer is releasing a customer? Enter officer ID: ");
                             int officerID = Integer.parseInt(stdin.readLine().trim());
 
                             Customer releasedCustomer = management1.releaseCustomerFromOfficer(officerID);
                             if (releasedCustomer == null)
                             {
                                 System.out.print("\nNo customer was released"+ "\n");
                             }
                             else
                             {
                                 System.out.print("\nCustomer " + releasedCustomer.toString() + " was serviced and checked out\n");
                             }
                         }
                         catch(NumberFormatException ex)
                         {
                             System.out.print("\nPlease enter a valid number");
                         }
                         break;
                     case 'S':   //Assign a Customer to a loan officer
                         Customer customer2 = management1.assignCustomerToLoanOfficer();
 
                         if (customer2 == null)
                         {
                             System.out.print("\nNo customer was assigned to the loan officer" + "\n");
                         }
                         else
                         {
                             System.out.print("\nCustomer " + customer2.toString() + " was assigned to a loan officer" + "\n");
                         }
                         break;
                     case '?':   //Display Menu
                         printMenu();
                         break;
                     default:
                         System.out.print("\nUnknown action");
                         break;
                 }
             }
             else
             {
                 System.out.print("\nUnknown action");
             }
         } while (input1 != 'Q' || line.length() != 1);
     }
 
     /** The method printMenu displays the menu to a user**/
     public static void printMenu()
     {
         System.out.print("Choice\t\tAction\n" +
                 "------\t\t------\n" +
                 "A\t\tAdd Customer\n" +
                 "C\t\tCheck Out Customer\n" +
                 "L\t\tList Customer Queues\n" +
                 "Q\t\tQuit\n" +
                 "R\t\tRelease Customer From Loan Officer\n" +
                 "S\t\tAssign Customer To Loan Officer\n" +
                 "?\t\tDisplay Help\n\n");
     }
 }