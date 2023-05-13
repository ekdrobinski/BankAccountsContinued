public class BankAccount {
    private double amount;
    private String yourName;
    private int accountNum;
    public BankAccount(double accountBalance, String customerName, int customerAccountNum){
        this.amount = accountBalance; //balance
        this.yourName = customerName; //person name
        this.accountNum = customerAccountNum; //account number
    }
    public BankAccount(){
    }
    public double getAmount() {
        return amount;
    }
    public String getYourName() {
        return yourName;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void deposit(double moneyToAdd){
        amount = amount + moneyToAdd;
    }

    public void withdraw(double moneyToRemove){
        amount = amount - moneyToRemove;
    }

    public String accountDetails(){
        String accountAlert = this.yourName+ "'s Account balance: " + this.amount;
        System.out.println(accountAlert);
        return accountAlert;
    }
}

