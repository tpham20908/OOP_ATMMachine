/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;
import java.util.Scanner;

public class Withdrawal extends Transaction 
{
  
  public Withdrawal(int accountNo, BankData bankData) 
  {
    super(accountNo, bankData);
  }
  
  BankData currentBankData = getBankData();
  double currentBalance = currentBankData.getBalance(getAccountNo());
  int currentLimit = currentBankData.getLimit(getAccountNo());
  
  @Override
  void transaction() 
  {
    int amount = chooseAmount();
    currentBalance -= amount;
    currentLimit -= amount;
    System.out.println("You have withdrawn $" + amount
      + "\nYour current balance is $" + currentBalance
      + "\nYour current limit is $" + currentLimit);
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
        System.out.println("=> The amount withdrawn cannot excess $" 
                + Math.min(currentBalance, currentLimit));
        System.out.print("Enter the amount again: ");
        amount = input.nextInt();
      }
    }
    while (amount % 5 != 0);
    return amount;
  }
}
