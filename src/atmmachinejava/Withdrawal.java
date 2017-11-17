/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;
import java.util.Scanner;

public class Withdrawal extends Transaction 
{
  
  public Withdrawal(int accountNo, Account account) 
  {
    super(accountNo, account);
  }
  
  double currentBalance = account.getBalance();
  int currentLimit = account.getLimit();
  
  @Override
  void transaction() 
  {
    if (currentLimit > 0)
    {
      int amount = chooseAmount();
      currentBalance -= amount;
      currentLimit -= amount;
      account.setBalance(currentBalance);
      account.setLimit(currentLimit);
      System.out.println("You have withdrawn $" + amount
        + "\nYour current balance is $" + currentBalance
        + "\nYour current limit is $" + currentLimit);
    }
    else
      System.out.println("!!!You have reached the withdrawal limit today!!!");
  }
  
  int chooseAmount()
  {
    int amount;
    Scanner input = new Scanner(System.in);
    System.out.println("******************************");
    do
    {
      System.out.print("Enter the amount withdrawn (no coins accepted): " );
      amount = input.nextInt();
      while (amount > currentLimit || amount > currentBalance)
      {
        System.out.println("Your current balance is $" + currentBalance
          + "\nYour limit withdrawal is $" + currentLimit);
        System.out.println("=> The amount withdrawn today cannot excess $" 
                + Math.min(currentBalance, currentLimit));
        System.out.print("Enter the amount again: ");
        amount = input.nextInt();
      }
    }
    while (amount % 5 != 0);
    return amount;
  }
}
