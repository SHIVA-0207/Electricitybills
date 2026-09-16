class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}

interface BankAccount {

    void deposit(double amount) throws InvalidInputException;

    void withdraw(double amount)
            throws InsufficientBalanceException, InvalidInputException;

    double getBalance();
}

class SavingsAccount implements BankAccount {

    private String holderName;
    private int accountNumber;
    private double balance;

    public SavingsAccount(String holderName, int accountNumber,
                           double initialBalance) {

        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) throws InvalidInputException {

        if (amount <= 0) {
            throw new InvalidInputException(
                    "Deposit amount must be positive."
            );
        }

        balance += amount;

        System.out.println("Output");
        System.out.println("Amount Deposited Successfully");
        System.out.println("Available Balance: Rs. " + (int) balance);
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, InvalidInputException {

        if (amount <= 0) {
            throw new InvalidInputException(
                    "Withdrawal amount must be positive."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Exception: Insufficient Balance\nTransaction Failed"
            );
        }

        balance -= amount;

        System.out.println("Output");
        System.out.println("Amount Withdrawn Successfully");
        System.out.println("Available Balance: Rs. " + (int) balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

public class BankOperations {

    public static void main(String[] args) {

        System.out.println("TEST CASE 1 – DEPOSIT OPERATION");

        System.out.println("\nInput");

        String name1 = "Ram";
        int acc1 = 1001;
        double initBal1 = 5000;
        String op1 = "Deposit";
        double depAmt = 2000;

        System.out.println("Account Holder Name: " + name1);
        System.out.println("Account Number: " + acc1);
        System.out.println("Initial Balance: " + (int) initBal1);
        System.out.println("Operation: " + op1);
        System.out.println("Deposit Amount: " + (int) depAmt);
        System.out.println();

        BankAccount account1 =
                new SavingsAccount(name1, acc1, initBal1);

        try {

            account1.deposit(depAmt);

        } catch (InvalidInputException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\n=========================================\n");

        
        System.out.println(
                "TEST CASE 2 – WITHDRAW OPERATION (INSUFFICIENT BALANCE)"
        );

        System.out.println("\nInput");

        String name2 = "Karthik";
        int acc2 = 1003;
        double initBal2 = 4000;
        String op2 = "Withdraw";
        double withdrawAmt = 6000;

        System.out.println("Account Holder Name: " + name2);
        System.out.println("Account Number: " + acc2);
        System.out.println("Initial Balance: " + (int) initBal2);
        System.out.println("Operation: " + op2);
        System.out.println("Withdraw Amount: " + (int) withdrawAmt);
        System.out.println();

        BankAccount account2 =
                new SavingsAccount(name2, acc2, initBal2);

        try {

            account2.withdraw(withdrawAmt);

        } catch (InsufficientBalanceException | InvalidInputException e) {

            System.out.println(e.getMessage());
            System.out.println(
                    "Available Balance: Rs." +
                    (int) account2.getBalance()
            );
        }
    }
}
