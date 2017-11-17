/**
 *
 * @author Thanh-Tung Pham 1796137
 */
package atmmachinejava;
import java.util.Scanner;

public class ATM 
{
  private boolean userAuthenticated;
  private int currentAccountNo;
  private BankData bankData;
  
  // constants corresponding to main menu options
  private static final int WITHDRAWAL = 1;
  private static final int DEPOSIT = 2;
  private static final int DISPLAY_BALANCE = 3;
  private static final int CHANGE_PIN = 4;
  private static final int EXIT = 5;
  
  public ATM() 
  {
    userAuthenticated = false; 
    currentAccountNo = 0;
    bankData = new BankData();
  }
  
  public void run()
  {
    while (true)
    {
      while (!userAuthenticated)
      {
        System.out.println("\nWelcome to ATM Banking!");
        authenticatedUser();
      }
      System.out.println("Login successfully!");
      performTransaction();
      userAuthenticated = false;
      
      System.out.println("Thank you for using ATM banking!".toUpperCase());
      System.out.println("******************************");
    }
  }
  /**
   * authenticatedUser() validate account number and PIN
   * and set currentAccountNo
   */
  public void authenticatedUser() 
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your Account number: ");
    int accountNoInput = input.nextInt();
    System.out.print("Enter your PIN: ");
    int pinInput = input.nextInt();
    
    userAuthenticated = bankData.validateUser(accountNoInput, pinInput);
    if (userAuthenticated)
      currentAccountNo = accountNoInput;
    else
      System.out.println("Invalid Account Number or PIN. "
              + "Please try again.");
  }
  
  public void performTransaction() 
  {
    Transaction currentTransaction = null;
    boolean userExited = false;
    while (!userExited)
    {
      int menuSelection = selectMenu();
      switch (menuSelection)
      {
        case WITHDRAWAL:
          currentTransaction = new Withdrawal(currentAccountNo, bankData);
          currentTransaction.transaction();
          break;
        case DEPOSIT:
          currentTransaction = new Deposit(currentAccountNo, bankData);
          currentTransaction.transaction();
          break;
        case DISPLAY_BALANCE:
          currentTransaction = new DisplayBalance(currentAccountNo, bankData);
          currentTransaction.transaction();
          break;
        case CHANGE_PIN:
          currentTransaction = new ChangePIN(currentAccountNo, bankData);
          currentTransaction.transaction();
          break;
        case EXIT:
          System.out.println("Exiting system.");
          userExited = true;
          break;
        default:
          System.out.println("Invalid selection.");
      }
    }
  }
  
  /**
   * @return number corresponding user's choice from Main Menu
   */
  private int selectMenu()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("\n******************************");
    System.out.println("Main Menu".toUpperCase());
    System.out.println("1. Withdrawal");
    System.out.println("2. Deposit");
    System.out.println("3. Display Balance");
    System.out.println("4. Change PIN");
    System.out.println("5. Exit");
    System.out.print("Enter choice: ");
    return input.nextInt();
  }
} 