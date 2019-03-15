package sample;

public class Processes {
    private double balance;
    private String creditCardNumber = "123456";


    public Processes() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Deposit(double amount) {
        this.balance += amount;
    }

    public void Withdrawl(double amount) {
            this.balance -= amount;
    }

    public boolean validate(String cardNumber) {
        boolean validateCreditCardNumber = false;
        if (cardNumber != null) {
            validateCreditCardNumber = this.creditCardNumber.equals(cardNumber);
        }
        return validateCreditCardNumber;
    }
}
