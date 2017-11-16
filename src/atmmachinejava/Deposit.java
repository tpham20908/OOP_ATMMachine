/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class Deposit extends Transaction {
  double amount;
  
  public Deposit(int accountNo, Account account) {
    super(accountNo, account);
  }
  
  @Override
  void transaction() {
    
  }
}
