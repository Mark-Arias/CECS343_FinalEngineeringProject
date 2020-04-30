package Backend;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class models the text based interface a user is shown
 */
public class Menu {

    // create an instance of the ATM class for use in facilitating
    private final ATM machine = new ATM();

    /**
     * Launches application. Can only continue when correct card is inserted.
     */
    void launch() {
        ArrayList<Account> accounts = machine.getAccounts();    // get accounts from atm machine data
        if (machine.verifyLogin())  displayMenu(accounts);      // pass in accounts to displayMenu method
        else    machine.verifyLogin();
    }

    /**
     * Displays menu only if launch conditions were satisfied and handles inputs and outputs.
     * @param accounts list of accounts
     */
    void displayMenu(ArrayList<Account> accounts) {

        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.print("1) Withdraw Funds\n" +
                    "2) Deposit Funds\n" +
                    "3) Transfer Funds\n" +
                    "4) Check Balance\n" +
                    "5) Quit\n" +
                    "-------------------\nEnter selection: ");
            choice = in.nextInt();

            switch(choice) {                // switch through user response cases
                case 1:
                    withdrawFunds(accounts);
                    break;
                case 2:
                    depositFunds(accounts);
                    break;
                case 3:
                    transferFunds(accounts);
                    break;
                case 4:
                    checkBalance(accounts);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Withdraw funds from selected account
     * @param accounts list of accounts
     */
    void withdrawFunds(ArrayList<Account> accounts) {
        Scanner in = new Scanner(System.in);
        int choice;
        double amt;

        System.out.println("Choose which account to withdraw from: ");

        for (int i = 0; i < accounts.size(); i++)
            System.out.println((i + 1) + ") " + accounts.get(i));   // iterate through contained accounts
        choice = in.nextInt();  // get user response

        Account temp = accounts.get(choice - 1);    // stored selected account object in temp

        System.out.println("Enter amount to withdraw: ");
        amt = in.nextDouble();

        if (machine.withdrawFunds(temp, amt))   // attempt to use atm class method
            System.out.println("Successfully withdrew $" + amt + "\nCurrent Balance: " + temp.getBalance());

    }

    //TODO: There was a bug i encountered when moving money back and forth
    // there was an index out of bounds error, and the 200 withdraw limit was static, even with larger funds
    /**
     * Deposits into selected account.
     * @param accounts list of accounts
     */
    void depositFunds(ArrayList<Account> accounts) {
        Scanner in = new Scanner(System.in);
        int choice;
        double amt;

        System.out.println("Choose which account to deposit to: ");

        for (int i = 0; i < accounts.size(); i++)
            System.out.println((i + 1) + ") " + accounts.get(i));   // iterate through contained accounts
        choice = in.nextInt();  // get user response

        Account temp = accounts.get(choice - 1);    // stored selected account object in temp

        System.out.println("Enter amount to deposit: ");
        amt = in.nextDouble();

        if(machine.depositFunds(temp,amt)) {    // attempt to use depositFunds() method from atm class
            System.out.println("Successfully deposited $" + amt + "\nCurrent Balance: " + temp.getBalance());
        }

    }


    /**
     * Transfer funds between the specified accounts
     * @param accounts list of accounts
     */
    void transferFunds(ArrayList<Account> accounts) {
        Scanner in = new Scanner(System.in);
        int choice;
        double amt;

        System.out.println("Transfer of Funds Selected");
        System.out.println("Enter amount to transfer: ");
        amt = in.nextDouble();

        // request origin account to get money from
        System.out.println("Choose which account to transfer from: ");
        for (int i = 0; i < accounts.size(); i++)
            System.out.println((i + 1) + ") " + accounts.get(i));   // iterate through contained accounts
        choice = in.nextInt();  // get user response
        Account origin = accounts.get(choice - 1);    // stored selected account object in temp

        // request recipient account to send money to
        System.out.println("Choose which account to transfer to: ");
        for (int i = 0; i < accounts.size(); i++)
            System.out.println((i + 1) + ") " + accounts.get(i));   // iterate through contained accounts
        choice = in.nextInt();  // get user response
        Account recipient = accounts.get(choice - 1);    // stored selected account object in temp


        if(machine.transferFunds(origin,recipient,amt)) {   // attempt transferFunds() operation
            System.out.println("Successfully transferred $" + amt);
        }
    }

    /**
     * Check the current montary balance of the users desired account
     * @param accounts list of accounts
     */
    void checkBalance(ArrayList<Account> accounts) {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("Choose which account to check balance of: ");

        for (int i = 0; i < accounts.size(); i++)
            System.out.println((i + 1) + ") " + accounts.get(i));   // iterate through contained accounts
        choice = input.nextInt();  // get user response

        Account temp = accounts.get(choice - 1);    // stored selected account object in temp
        System.out.println(temp);

    }
}
