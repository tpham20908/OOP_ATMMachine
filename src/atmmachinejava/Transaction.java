/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class Transaction {
  int accountNo;
  Account account;
  
  public Transaction(int accountNo, Account account) {
    this.accountNo = accountNo;
    this.account = account;
  }
  
  int getAccountNo() {
    return accountNo;
  }
  
  void transaction() {
    
  }
}
