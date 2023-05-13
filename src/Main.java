import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount(500, "Anon", 1));
        accounts.add(new BankAccount(5000, "Larry", 2));
        accounts.add(new BankAccount(300, "Mary", 3));

        System.out.println("Hello! Welcome!");
        System.out.println("Are you an existing customer? (Enter -1 to exit)");
        System.out.println("Enter 1 for yes.");
        System.out.println("Enter 2 for no.");

        int existingCustomer = Integer.valueOf(scanner.nextLine()); //puts input into a variable
        if (existingCustomer == 1){

            System.out.println("What is your name?");
            String userName = scanner.nextLine();

            System.out.println("What is your account number");
            int userAccountNum = Integer.valueOf(scanner.nextLine());


            mainMenu(userName, userAccountNum, accounts);

        } else if (existingCustomer == 2){
            System.out.println("Let's make a new account!");
            System.out.println("What is your name?");
            String newUserName = scanner.nextLine();
            System.out.println("What is the beginning balance for the account?");
            double newAccountAmount = Double.valueOf(scanner.nextLine());
            int newAccountNum = accounts.size() + 1;

            //add user to array
            accounts.add(new BankAccount(newAccountAmount, newUserName, newAccountNum));

            mainMenu(newUserName, newAccountNum, accounts);

        } else if(existingCustomer == -1){
            System.out.println("Exited. Program ended.");
        } else{
            System.out.println("Please enter a valid value.");
        }
    }
    private static void mainMenu(String userName, int userAccountNum, ArrayList<BankAccount> accounts) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hello " + userName + "!");
            System.out.println("Welcome to the Main menu, what would you like to do today?");
            System.out.println("Enter 1 to check account balance.");
            System.out.println("Enter 2 to make a withdrawal.");
            System.out.println("Enter 3 to make a deposit.");
            System.out.println("Enter 4 to make a transfer to another account.");
            System.out.println("Enter 0 to exit.");
            int optionSelected = Integer.valueOf(scanner.nextLine());

            if (optionSelected == 1) {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == userAccountNum) {
                        accounts.get(i).accountDetails();
                    }
                }

            } else if (optionSelected == 2) {
                System.out.println("How much would you like to withdraw?");
                double withdrawAmount = Double.valueOf(scanner.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == userAccountNum) {
                        accounts.get(i).withdraw(withdrawAmount);
                        accounts.get(i).accountDetails();
                    }
                }
            } else if (optionSelected == 3) {
                System.out.println("How much would you like to deposit?");
                double depositAmount = Double.valueOf(scanner.nextLine());
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getAccountNum() == userAccountNum) {
                        accounts.get(i).deposit(depositAmount);
                        accounts.get(i).accountDetails();
                    }
                }
            } else if (optionSelected == 4) {
                System.out.println("Please enter the account number to transfer to");
                int transferTo = Integer.valueOf(scanner.nextLine());

                if (transferTo > accounts.size()){
                    System.out.println("Account does not exist");
                    mainMenu(userName, userAccountNum, accounts);
                }
                System.out.println("Please enter the amount to transfer");
                double transferAmount = Double.valueOf(scanner.nextLine());
                transfer(userAccountNum, transferTo, transferAmount, accounts);

            } else if (optionSelected == 0) {
                System.out.println("Exiting the account. Goodbye.");
                break;
            } else {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    private static void transfer(int userAccountNum, int transferTo, double transferAmount, ArrayList<BankAccount> accounts){

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNum() == userAccountNum ){
                System.out.println("The name on this account is: " + accounts.get(i).getYourName() +
                        " and they have a starting balance of " + accounts.get(i).getAmount());
                accounts.get(i).withdraw(transferAmount);
                System.out.println("The name on this account is: " + accounts.get(i).getYourName() +
                        " and they have a remaining balance of " + accounts.get(i).getAmount());
            }
            if (accounts.get(i).getAccountNum() == transferTo){
                System.out.println("The name on this account is: " + accounts.get(i).getYourName() +
                        " and they have a starting balance of " + accounts.get(i).getAmount());
                accounts.get(i).deposit(transferAmount);
                System.out.println("The name on this account is: " + accounts.get(i).getYourName() +
                        " and they have a remaining balance of " + accounts.get(i).getAmount());
            }
        }
    }
}