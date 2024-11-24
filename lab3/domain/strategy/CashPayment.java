package domain.strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing cash payment...");
        System.out.println("Amount Paid: $" + amount);
    }
}
