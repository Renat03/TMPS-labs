package domain2.adapter;

import external2.PayPalPaymentService;

public class PayPalAdapter implements PaymentProcessor {
    private final PayPalPaymentService payPalPaymentService;
    private final String userEmail;

    public PayPalAdapter(String userEmail) {
        this.payPalPaymentService = new PayPalPaymentService();
        this.userEmail = userEmail;
    }

    @Override
    public void processPayment(double amount) {
        payPalPaymentService.makePayment(userEmail, amount);
    }
}
