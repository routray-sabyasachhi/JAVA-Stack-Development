package Java.OOPs.Abstraction;

interface Payment {
    void pay(double amount);
}

// upi payment
class UpiPayment implements Payment{
    private String upiId;

    UpiPayment(String upiId){
        this.upiId = upiId;
    }

    public void pay(double amount) {
        validateUpi();
        System.out.println("Paid " + amount + " using UPI ID: " + upiId);
    }

    private void validateUpi(){
        System.out.println("UPI validated");
    }
}

// card payment
class CardPayment implements Payment {
    private String cardNumber;

    CardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void pay(double amount){
        validateCard();
        System.out.println("Paid "+ amount + " using card: " + cardNumber);
    }
    private void validateCard(){
        System.out.println("Card validated");
    }
}

class CheckOut {
    void completePayment(Payment payment, double amount){
        payment.pay(amount);
    }
}

public class Payment_System {
    public static void main(String[] args) {
        CheckOut checkout = new CheckOut();

        checkout.completePayment(new UpiPayment("Sabya@upi"), 15000);
        checkout.completePayment(new CardPayment("XXXX-5034"), 25000);
    }
}
