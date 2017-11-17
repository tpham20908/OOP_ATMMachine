/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;
import java.util.Scanner;

public class ChangePIN extends Transaction {
  
  public ChangePIN(int accountNo, Account account) {
    super(accountNo, account);
  }
  
  int currentPin = account.getPin();
  
  @Override
  void transaction() 
  {
    int pinInput, newPin1, newPin2;
    Scanner input = new Scanner(System.in);
    System.out.println("******************************");
    System.out.print("Enter your current PIN: ");
    pinInput = input.nextInt();
    if (pinInput == currentPin)
    {
      System.out.print("Enter your new PIN: ");
      newPin1 = input.nextInt();
      System.out.print("Re-enter your new PIN: ");
      newPin2 = input.nextInt();
      while (newPin1 != newPin2)
      {
        System.out.println("New PIN does not match.");
        System.out.print("Enter your new PIN: ");
        newPin1 = input.nextInt();
        System.out.print("Re-enter your new PIN: ");
        newPin2 = input.nextInt();
      }
      account.setPin(newPin2);
      System.out.println("Your new PIN is successfully updated.");
    }
    else
    {
      System.out.println("PIN does not match.");
    }
  }
}
