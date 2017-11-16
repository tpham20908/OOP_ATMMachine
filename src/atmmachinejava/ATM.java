/**
 *
 * @author Thanh-Tung Pham 1796137
 */
package atmmachinejava;

public class ATM {
  private double balance;
  private int accountNo;
  private Account account;
  
  // constants corresponding to main menu options
  private static final int WITHDRAWAL = 1;
  private static final int DEPOSIT = 2;
  private static final int DISPLAY_BALANCE = 3;
  private static final int CHANGE_PIN = 4;
  private static final int EXIT = 5;
  
  public ATM() {
    this.balance = 0;
    this.accountNo = 0;
  }
  
  boolean validate() {
    
    return true;
  }
} 