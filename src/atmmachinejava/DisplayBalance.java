/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class DisplayBalance extends Transaction {

  public DisplayBalance(int accountNo, BankData bankData) {
    super(accountNo, bankData);
  }
  
  @Override
  void transaction() {
    BankData currentBankData = getBankData();
    double currentBalance = currentBankData.getBalance(getAccountNo());
    System.out.println("******************************");
    System.out.println("Your currently balance is $" + currentBalance);
  }
}
