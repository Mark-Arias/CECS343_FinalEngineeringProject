package Backend;

public class Savings extends Account {

    public Savings(int accNum, double balance, double withdrawLimit, ATM_Card card) {
        super(accNum, balance, withdrawLimit, card);
    }

    @Override
    public String toString() {
        return "Type: Savings\n" + super.toString();
    }
}
