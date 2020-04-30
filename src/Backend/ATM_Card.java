package Backend;

public class ATM_Card {

    private int cardNum;
    private int pin;

    public ATM_Card(int cardNum, int pin) {
        this.cardNum = cardNum;
        this.pin = pin;
    }

    int getCardNum() {
        return cardNum;
    }

    int getPin() {
        return pin;
    }

    void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "\tCard Number: " + cardNum +"\n\tPIN: " + pin;
    }
}
