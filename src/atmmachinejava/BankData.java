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
  
  public BankData(int bankNo, String bankName, String address) 
  {
    accounts = new Account[3];
    accounts[0] = new Account(1234, 4321, 500, 2500.80);
    accounts[1] = new Account(12345, 54321, 400, 1500.50);
    accounts[0] = new Account(123456, 654321, 1000, 500.0);
  }
  
  private Account getAccount(int accountNo)
  {
    for (Account account : accounts)
    {
      if (account.getAccountNo() == accountNo) 
        return account;
    }
    return null;
  }
  
  public boolean authenticateUser(int accountNo, int pin)
  {
    Account userAccount = getAccount(accountNo);
    if (userAccount != null)
      return userAccount.validate(accountNo, pin);
    else
      return false;
  }
}
