public class ATM {

    int balance;

    public ATM(int balance) {
        this.balance = balance;
    }

    public boolean deposit(int amount) {
        if (amount <= 0)
            return false;

        this.balance += amount;
        return true;
    }

    public boolean withdraw(int amount) throws InsufficientFundsException {

        if(amount > balance)
            throw new InsufficientFundsException("You only have "+balance+" amount in your account!");

        if (amount <= 0)
            throw new IllegalArgumentException("Amount can not be negative!");

        this.balance -= amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
