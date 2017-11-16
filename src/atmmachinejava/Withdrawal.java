/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class Withdrawal extends Transaction {
  double amount;
  
  public Withdrawal(int accountNo, Account account) {
    super(accountNo, account);
  }
  
  @Override
  void transaction() {
    
  }
}
