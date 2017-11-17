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
  private final BankData bankData;
  Transaction currentTransaction;
  
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
    // Program has to be terminated manually
    while (true)
    {
      while (!userAuthenticated)
      {
        System.out.println("******************************");
        System.out.println("Welcome to ATM Banking!");
        authenticatedUser();
      }
      System.out.println("Login successfully!");
      performTransaction();
      userAuthenticated = false;
      
      System.out.println("THANK YOU FOR USING ATM BANKING!");
    }
  }
  /**
   * authenticatedUser() validate account number and PIN
   * and set currentAccountNo
   */
  public void authenticatedUser() 
  {
    int count = 0;
    boolean checkedAccount = false;
    int accountNoInput = 0, pinInput;
    Scanner input = new Scanner(System.in);
    
    while (!checkedAccount)
    {
      System.out.print("Enter your Account number: ");
      accountNoInput = input.nextInt();
      checkedAccount = bankData.validateAccountNo(accountNoInput);
    }
    
    while (!userAuthenticated && count < 3)
    {
      System.out.printf("Enter your PIN (%d attempts): ", 3-count);
      pinInput = input.nextInt();
      userAuthenticated = bankData.validatePin(accountNoInput, pinInput);
      count++;
    }
    
    if (userAuthenticated)
      currentAccountNo = accountNoInput;
    else
      System.out.println("Invalid PIN. Login failed!");
  }
  
  public void performTransaction() 
  {
    Account currentAccount= bankData.getAccount(currentAccountNo);
    boolean userExited = false;
    while (!userExited)
    {
      int menuSelection = selectMenu();
      switch (menuSelection)
      {
        case WITHDRAWAL:
          currentTransaction = new Withdrawal(currentAccountNo, currentAccount);
          currentTransaction.transaction();
          break;
        case DEPOSIT:
          currentTransaction = new Deposit(currentAccountNo, currentAccount);
          currentTransaction.transaction();
          break;
        case DISPLAY_BALANCE:
          currentTransaction = new DisplayBalance(currentAccountNo, currentAccount);
          currentTransaction.transaction();
          break;
        case CHANGE_PIN:
          currentTransaction = new ChangePIN(currentAccountNo, currentAccount);
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
    System.out.println("******************************");
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