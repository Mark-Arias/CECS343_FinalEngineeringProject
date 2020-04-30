package Backend;

public abstract class Account {

    private int accNum;
    private double balance;
    private double withdrawLimit;
    private ATM_Card card;

    /**
     * Constructor for Account class
     * @param accNum account number
     * @param balance present balance
     * @param withdrawLimit withdraw limit
     * @param card ATM card associated with account
     */
    public Account(int accNum, double balance, double withdrawLimit, ATM_Card card) {
        this.accNum = accNum;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
        this.card = card;
    }

    int getAccNum() {
        return accNum;
    }

    double getBalance() {
        return balance;
    }

    double getWithdrawLimit() {
        return withdrawLimit;
    }

    ATM_Card getCard() {
        return card;
    }

    void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    void setCard(ATM_Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Account Number: " + accNum + "\nBalance: $" + balance + "\nWithdraw Limit: $" + withdrawLimit;
    }
}
