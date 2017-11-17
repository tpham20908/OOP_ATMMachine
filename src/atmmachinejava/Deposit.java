/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;
import java.util.Scanner;

public class Deposit extends Transaction {
  
  public Deposit(int accountNo, Account account) 
  {
    super(accountNo, account);
  }
  
  double currentBalance = account.getBalance();
  int currentLimit = account.getLimit();
  
  @Override
  void transaction() 
  {
    int amount = chooseAmount();
    currentBalance += amount;
    account.setBalance(currentBalance);
    System.out.println("You have deposited $" + amount
      + "\nYour current balance is $" + currentBalance);
  }
  
  int chooseAmount()
  {
    int amount;
    Scanner input = new Scanner(System.in);
    System.out.println("******************************");
    do
    {
      System.out.print("Enter the amount deposited (no coins accepted): " );
      amount = input.nextInt();
    }
    while (amount % 5 != 0);
    return amount;
  }
}
