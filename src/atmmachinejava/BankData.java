/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class BankData 
{
  private Account[] accounts;
  
  public BankData() 
  {
    accounts = new Account[3];
    // (accountNo, PIN, limit, balance)
    accounts[0] = new Account(1234, 4321, 500, 2575.80);
    accounts[1] = new Account(2345, 5432, 400, 1543.50);
    accounts[2] = new Account(3456, 6543, 800, 550.30);
  }
  
  public Account getAccount(int accountNo)
  {
    for (Account account : accounts)
    {
      if (account.getAccountNo() == accountNo)
        return account;
    }
    return null;
  }
  
  public boolean validateAccountNo(int accountNo)
  {
    Account userAccount = getAccount(accountNo);
    return userAccount != null;
  }
  
  public boolean validatePin(int accountNo, int pin)
  {
    Account userAccount = getAccount(accountNo);
    return userAccount.validate(pin);
  }
  
  public double getBalance(int accountNo)
  {
    return getAccount(accountNo).getBalance();
  }
  
  public int getLimit(int accountNo)
  {
    return getAccount(accountNo).getLimit();
  }
  
  public int getPin(int accountNo)
  {
    return getAccount(accountNo).getPin();
  }
}
