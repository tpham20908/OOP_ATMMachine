/**
 *
 * @author Thanh-Tung Pham
 */
package atmmachinejava;

public class Account 
{
  private int accountNo, pin, limit;
  private double balance;
  
  
//  Customer customer;
  
  public Account(int accountNo, int pin, int limit, double balance) 
  {
    this.accountNo = accountNo;
    this.pin = pin;
    this.limit = limit;
    this.balance = balance;
  }
  
  public boolean validate(int inputAccountNo, int inputPin) 
  {
    return (inputAccountNo == accountNo && inputPin == pin);
  }
  
  public int getLimit() 
  {
    return limit;
  }
  
  public double getBalance()
  {
    return balance;
  }
  
  public int getAccountNo() 
  {
    return accountNo;
  }
  
  public int getPin() 
  {
    return pin;
  }
  
  public void credit(double amount) 
  {
    balance += amount;
  }
  
  public void debit(double amount)
  {
    limit -= amount;
    balance -= amount;
  }
}
