package external;

public class PayPalPaymentService {
    public void makePayment(String userEmail, double paymentAmount) {
        System.out.println("Processing payment via PayPal:");
        System.out.println("User Email: " + userEmail);
        System.out.println("Amount: $" + paymentAmount);
    }
}
