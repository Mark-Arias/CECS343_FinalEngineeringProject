package Backend;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    /**
     * Generates accounts
     * @return returns a list of generated accounts
     */
    ArrayList<Account> getAccounts() {
        ArrayList<Account> list = new ArrayList<>();
        list.add(new Checking(1234, 500, 200, new ATM_Card(5021, 4209)));
        list.add(new Savings(5678, 2000, 500, new ATM_Card(5021, 4209)));
        return list;
    }

    /**
     *
     * @return returns whether or not the users card was inserted properly with the right credentials
     */
    boolean verifyLogin() {
        Scanner in = new Scanner(System.in);

        int actualPin = 4240;
        int actualCard = 5021;

        System.out.print("Enter card number: ");
        int cardNum = in.nextInt();

        if (cardNum != actualCard) {
            System.out.println("Invalid card number.");
            return false;
        }

        System.out.print("Enter PIN: ");
        int pin = in.nextInt();

        if (pin != actualPin) {
            System.out.println("Invalid PIN");
            return false;
        }

        return true;
    }

    /**
     * Withdraw funds from selected account
     * @param acc Account to be withdrawn from.
     * @param amt Amount to be withdrawn.
     * @return returns whether or not the transaction was successful.
     */
    boolean withdrawFunds(Account acc, double amt) {
        if (amt > acc.getBalance()) {
            System.out.println("Cannot withdraw funds greater than amount currently present.");
            return false;
        } else if (amt < 0) {
            System.out.println("Cannot be a value less than 0.");
            return false;
        } else if (amt > acc.getWithdrawLimit()) {
            System.out.println("Cannot withdraw funds greater than the withdraw limit.");
            return false;
        } else {
            acc.setBalance(acc.getBalance() - amt);
            return true;
        }
    }

    /**
     * Method for transferring funds from origin account to recipient
     * @param origin original account
     * @param recipient recipient account
     * @param amt amount to transfer
     * @return returns whether or not the the transaction was successful
     */
    boolean transferFunds(Account origin, Account recipient, double amt) {
        if (amt > origin.getBalance()) {
            System.out.println("Cannot transfer funds greater than amount currently present.");
            return false;
        } else if (amt < 0) {
            System.out.println("Cannot be a value less than 0.");
            return false;
        } else if (amt > origin.getWithdrawLimit()) {
            System.out.println("Cannot transfer a value more than the limit.");
            return false;
        } else {
            origin.setBalance(origin.getBalance() - amt);
            recipient.setBalance(recipient.getBalance() + amt);
            return true;
        }
    }

    /**
     * method for depositing funds into an account
     * @param acc account to be deposited into
     * @param amt amount to be deposited
     * @return returns whether or not the transaction was successful
     */
    boolean depositFunds(Account acc, double amt) {
        if (amt < 0) {
            System.out.println("Cannot deposit a negative amount.");
            return false;
        } else {
            acc.setBalance(acc.getBalance() + amt);
            return true;
        }
    }
}
