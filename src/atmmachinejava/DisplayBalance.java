/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class DisplayBalance extends Transaction {

  public DisplayBalance(int accountNo, Account account) {
    super(accountNo, account);
  }
  
  @Override
  void transaction() {
    double currentBalance = account.getBalance();
    System.out.println("******************************");
    System.out.println("Your currently balance is $" + currentBalance);
  }
}
