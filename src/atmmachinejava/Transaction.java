/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public abstract class Transaction
{
  int accountNo;
  Account account;
  BankData bankData;
  
  public Transaction(int accountNo, Account account) 
  {
    this.accountNo = accountNo;
    this.account = account;
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
