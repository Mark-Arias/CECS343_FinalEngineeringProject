package Backend;

public class Checking extends Account {

    public Checking(int accNum, double balance, double withdrawLimit, ATM_Card card) {
        super(accNum, balance, withdrawLimit, card);
    }
    @Override
    public String toString() {
        return "Type: Checking\n" + super.toString();
    }
}
