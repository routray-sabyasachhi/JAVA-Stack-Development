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

    public double amount;
    public double percentage;
    public double buyingPrice;
    public double sellingPrice;

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

    public double buyingPrice;
    public double sellingPrice;

    public TakeInput() {

        Scanner sc = new Scanner(System.in);

        buyingPrice = readPrice(sc, "Enter Buying Price : ");
        sellingPrice = readPrice(sc, "Enter Selling Price : ");

        sc.close();
    }

    private double readPrice(Scanner sc, String message) {
        System.out.print(message);
        return Double.parseDouble(sc.nextLine().replace("\uFEFF", "").trim());
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}
