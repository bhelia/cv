import java.util.Scanner;

public class GroceryShopping {
    public static void main(String []args) {
        String [] GroceryItem = new String[10];
        float [] ItemPrice = new float[10];
        GroceryItem[0] = "Orange"; ItemPrice[0] = 8.35f;
        GroceryItem[1] = "Banana"; ItemPrice[1] = 5.25f;
        GroceryItem[2] = "Bread"; ItemPrice[2] = 3.50f;
        GroceryItem[3] = "Milk"; ItemPrice[3] = 3.40f;
        GroceryItem[4] = "Eggs"; ItemPrice[4] = 5.45f;
        GroceryItem[5] = "cheese"; ItemPrice[5] = 7.25f;
        GroceryItem[6] = "chicken"; ItemPrice[6] = 18.25f;
        GroceryItem[7] = "Rice";   ItemPrice[7] = 5.25f;
        GroceryItem[8] = "Pasta"; ItemPrice[8] = 5.25f;
        GroceryItem[9] = "Tomato"; ItemPrice[9] = 2.15f;


        Scanner scan = new Scanner(System.in);

        String [] PurchaseList = new String[10];
        int billItemIndex = 0, numberOfItems = 0, selectionsCount = 0, selectedItem = 0;
        float total = 0.00f, subTotal = 0.00f;
        int [] CountPerItem = new int [10];
        float [] PricePerItem = new float[10];
        float [] BillTotals = new float [10];
        boolean itemFound = false;

        while (true) {

            System.out.println();
            System.out.println("Groceries available in the store:");
            System.out.println("=================================");
            System.out.println();

            for (int i = 0; i < GroceryItem.length; i++){
                System.out.println(i + 1 + " " + GroceryItem[i] + ", $ per unit: " + ItemPrice[i]);
            }

            System.out.println("=================================");
            System.out.println();
            System.out.println("\nEnter the grocery item or Finish to exit.");
            System.out.println();

            String userInput = scan.nextLine();

            // Exit the program if the user types "exit"
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("\nThank you for using the shopping cart. Goodbye!");
                break;
            }
            if (!userInput.equalsIgnoreCase("Finish")) {
                // check if the string matches an item on the shelf
                for (int checkIndex = 0; checkIndex < GroceryItem.length; checkIndex++) {
                    if (userInput.equalsIgnoreCase(GroceryItem[checkIndex])) {
                        itemFound = true;
                        selectedItem = checkIndex;
                    }
                }
                if (itemFound) {
                    System.out.println("\nPlease enter how many items you would like to purchase: ");
                    numberOfItems = scan.nextInt();
                    scan.nextLine();
                } else {
                    System.out.println("\nSorry, the store does not carry the item " + userInput);
                    System.out.println("\nThanks for shopping at FakeLab store, Goodbye!");
                    break;
                }

                if (numberOfItems >= 1) {
                   PurchaseList[billItemIndex] = userInput;
                   CountPerItem[billItemIndex] = numberOfItems;
                   PricePerItem[billItemIndex] = ItemPrice[selectedItem];
                   subTotal = numberOfItems * ItemPrice[selectedItem];
                   BillTotals[billItemIndex] = subTotal;

                //   System.out.println("BillTotal item:" + subTotal);
                } else {
                    System.out.println("\nSorry, we were expecting a number of " + userInput);
                    break;
                }

            } else {
                System.out.print("\nYour purchase is listed below: \n");
                for (int e = 0; e < billItemIndex; e++) {
                    System.out.println("  " + PurchaseList[e] + "  " + CountPerItem[e] + "  " + PricePerItem[e] + "  " + BillTotals[e]);
                }

                System.out.println("\nPlace order? answer with Yes or No: \n");
                if (scan.nextLine().equalsIgnoreCase("Yes")) {
                    ;
                    System.out.println("\nTotal Purchase ");
                    for (int t = 0; t < billItemIndex; t++) {
                        total = total + BillTotals[t];
                        //  System.out.println("Total #: " + t + "  " + total);
                    }
                    System.out.println(total);
                    System.out.println("\nThanks for shopping at FakeLab store, Goodbye!");
                    break;
                }
            }
         //   total =+ BillTotals[billItemIndex];
            billItemIndex = billItemIndex + 1;

        }
        scan.close();
    }
}