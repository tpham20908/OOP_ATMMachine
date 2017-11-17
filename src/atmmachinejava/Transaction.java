/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public abstract class Transaction
{
  int accountNo;
  BankData bankData;
  
  public Transaction(int accountNo, BankData bankData) 
  {
    this.accountNo = accountNo;
    this.bankData = bankData;
  }
  
  public int getAccountNo() 
  {
    return accountNo;
  }
  
  public BankData getBankData() 
  {
    return bankData;
  }
  
  abstract void transaction();
}
