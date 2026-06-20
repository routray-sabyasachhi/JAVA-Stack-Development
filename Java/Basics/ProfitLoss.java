import java.util.Scanner;

public class ProfitLoss {
    public static void main(String[] args) {

        TakeInput sellerData = new TakeInput();

        double buyingPrice = sellerData.getBuyingPrice();
        double sellingPrice = sellerData.getSellingPrice();

        ProfitLossCalculator calculator =
                new ProfitLossCalculator(buyingPrice, sellingPrice);

        calculator.displayResult();

        System.out.println("Profit Loss Calculation completed successfully");
    }
}

// Profit & Loss Calculation
class ProfitLossCalculator {

    private double amount;
    private double percentage;
    private double buyingPrice;
    private double sellingPrice;

    public ProfitLossCalculator(double buyingPrice, double sellingPrice) {
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;

        if (buyingPrice != sellingPrice) {
            amount = Math.abs(sellingPrice - buyingPrice);
            percentage = (amount / buyingPrice) * 100.0;
        }
    }

    public void displayResult() {

        if (sellingPrice > buyingPrice) {
            System.out.println("Profit Amount : " + amount);
            System.out.println("Profit Percentage : " + percentage + "%");
        }
        else if (buyingPrice > sellingPrice) {
            System.out.println("Loss Amount : " + amount);
            System.out.println("Loss Percentage : " + percentage + "%");
        }
        else {
            System.out.println("No Profit No Loss");
        }
    }
}

// Taking input from user
class TakeInput {

    private double buyingPrice;
    private double sellingPrice;

    public TakeInput() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Buying Price : ");
        buyingPrice = sc.nextDouble();

        System.out.print("Enter Selling Price : ");
        sellingPrice = sc.nextDouble();

        // Do not close System.in scanner in practice programs
        sc.close();
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}