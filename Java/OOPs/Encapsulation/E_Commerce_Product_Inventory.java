package Java.OOPs.Encapsulation;
import java.util.Scanner;

class Product{
    private int productId;
    private String productName;
    private double price;
    private int stock;

    public String setProductDetail(int takeId, String takeName, double takePrice, int takeStock) {
        if(takeId > 0)
            this.productId = takeId;
        else
            return "Invalid product Id";

        if(takeName.trim().isEmpty())
            return "Invalid product name";
        else
            this.productName = takeName;
        
        if((takeStock <= 0) && (takePrice <= 0)){
            return "Product detail Can't be saved. Please, Try again...";
        }else{
            this.stock = takeStock;
            this.price = takePrice;
        }

        //Give message to user
        return "Product detail saved Successfully...";
    }

    public void updatePrice(double newPrice){
        // update price
        if(newPrice > 0){
            this.price = newPrice;
            System.out.println("Update price successfully...");
        }else {
            System.out.println("Price update un-successfully... Please try again!");
        }
    }

    public void purchase(int quantity){
        // purchasing first check availability then puchase and update quantity.
       if(quantity > 0){
         if(quantity <= stock){
            stock -= quantity;
            System.out.println("Product purchase Successfully... \n");
        }else {
            System.out.println("Sorry! Available stock is " + this.stock);
        }
       }else{
        System.out.println("Invalid Quantity..");
       }
    }

    public void restock(int quantity){
        // update quantity
        if(quantity > 0) {
            this.stock += quantity;
        }else {
            System.out.println("Invalid quantity...");
        }

    }

    public void displayDetails(){
        // product detail diplay
        System.out.println("Product ID : " + this.productId +"\nProduct Name : " + this.productName + "\nPrice : " + this.price + "\nAvailable stock : " + this.stock);
        
    }
}

public class E_Commerce_Product_Inventory {
    public static void main(String[] args) {

        System.out.println("Welcome to Product Inventory Management System ");

        Scanner sc = new Scanner(System.in);

        System.out.print("Set Product Id : ");
        int takeId = sc.nextInt();
        sc.nextLine();
        System.out.print("Set product Name : ");
        String takeName = sc.nextLine();
        System.out.print("Set price of Product : ");
        double takePrice = sc.nextDouble();
        System.out.print("How mant stock do you have : ");
        int takeStock = sc.nextInt();

        Product p1 = new Product();

         String message = p1.setProductDetail(takeId, takeName, takePrice, takeStock);
         System.out.println(message);
         printDashed();

    
        while(true){

            // showing options
            printDashed();
            System.out.println(" 1. Display details => \n 2. Update Price =>\n 3. purchase => \n 4. Restock => \n 5. Quit =>");

            printDashed();

            // choose option 
            System.out.print("Choose One option :");

            int task = sc.nextInt();

            switch(task){

                case 1 :
                    // Product detail displayed
                    printDashed();
                    p1.displayDetails();
                    break;
                case 2 :
                    // update price
                    printDashed();
                    System.out.print("Enter Updated price : ");
                    double newPrice = sc.nextDouble();
                    p1.updatePrice(newPrice);
                    break;
                case 3 :
                    // product puchase
                    printDashed();
                    System.out.print("Enter quantity you want to puchase : ");
                    int quantity = sc.nextInt();
                    p1.purchase(quantity);
                    break;
                case 4 :
                    //Restock
                    printDashed();
                    System.out.print("Enter quanity to add into the stock : ");
                    int restock = sc.nextInt();
                    p1.restock(restock);
                    break;
                case 5 :
                    System.out.println("Quit successfully...");
                    printDashed();
                    sc.close();
                    return ;
                default :
                    System.out.println("Invalid choosen option... Choose Again !");    
            }
        }
    }

    public static void printDashed() {
            System.out.println("------------------------------------------------------------------");
        }
}
