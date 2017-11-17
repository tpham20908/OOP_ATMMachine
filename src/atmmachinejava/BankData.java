/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

// don't need to use this class (line 35 is a bit redundant)
// hard code new Account in ATM to test
public class BankData 
{
  private Account[] accounts;
  
  public BankData() 
  {
    accounts = new Account[3];
    accounts[0] = new Account(1234, 4321, 500, 2500.80);
    accounts[1] = new Account(12345, 54321, 400, 1500.50);
    accounts[2] = new Account(123456, 654321, 1000, 500.0);
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
  
  public boolean validateUser(int accountNo, int pin)
  {
    Account userAccount = getAccount(accountNo);
    if (userAccount != null)
      return userAccount.validate(pin);
    else
      return false;
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
