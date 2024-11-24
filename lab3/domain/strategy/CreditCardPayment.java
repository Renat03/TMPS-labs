package domain.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment...");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Amount Paid: $" + amount);
    }
}
