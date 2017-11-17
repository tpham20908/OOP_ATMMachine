/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;
import java.util.Scanner;

public class Deposit extends Transaction {
  
  public Deposit(int accountNo, BankData bankData) 
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
    currentBalance += amount;
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
