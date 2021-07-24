package com.shangce;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassMethods {

    // Declaration of variables
    private static final float pricesArray[] = {8.00f, 8.00f, 8.00f, 1.50f, 0.50f};
    private static int serialNo;
    private static String itemName;
    private static int itemQuantity;

    private static ArrayList<OrderDetails> orderList = new ArrayList<>();

    private static float subtotal;
    private static float tax;
    private static float tips;

    public static Scanner sc = new Scanner(System.in);

    // Printing out the menu for user to key in the order.
    public void menuDisplay(){

        System.out.println("-----------------------------\n            Menu\n-----------------------------");
        System.out.println("SINo   Item Name   Item Price \n-----------------------------");
        System.out.println(
                "1      Burger         $8.00\n" +
                        "2      Pasta          $8.00\n" +
                        "3      Chicken Roast  $8.00\n" +
                        "4      Coffee         $1.50\n" +
                        "5      Water          $0.50");
    }

    public void selectItems(){

        // Prompt user to key in the item serial number and the quantity of it. (Must be between 1-5).

        System.out.println("Enter the serial no. of the item ordered, 1 - 5 ");
        do
        {
            while (!sc.hasNextInt())
            {
                System.out.println("Please a valid integer number in the menu (1 to 5).");
                sc.next();
            }
            serialNo = sc.nextInt();
            if (serialNo > 5 || serialNo < 1)
            {
                System.out.println("Please a valid integer number in the menu (1 to 5).");
            }
        }
        while (serialNo > 5 || serialNo < 1);


        // Prompt user to input valid value for the item quantity
        System.out.println("Enter the quantity number of the item ordered");
        do
        {
            while (!sc.hasNextInt())
            {
                System.out.println("Please select a quantity integer between 0 and 300).");
                sc.next();
            }
            itemQuantity = sc.nextInt();
            if (itemQuantity < 1 || itemQuantity > 300)
            {
                System.out.println("Please select a quantity integer between 0 and 300).");
            }
        }
        while (itemQuantity < 1 || itemQuantity > 300);

        // Key in the order into the system
        keyOrder();

        // ASK for any next order, only take yes/no y/n for an answer

        while (true)
        {
            String promptOrder = sc.nextLine().toLowerCase();

            // If yes to more orders, call this method itself again.
            if (promptOrder.equals("yes") || promptOrder.equals("y"))
            {
                selectItems();
                break;
            }
            if (promptOrder.equals("no") || promptOrder.equals("n"))
            {
                System.out.println("Okay, we'll proceed to billing!");
                break;
            }
            else
            {
                System.out.println("Anymore order? Only (Yes/No, y/n)");
            }
        }
    }

    private void keyOrder(){

        // Switch cases to key in food order and its details such as quantity to the itemDetails ArrayList
        // Added spaces to itemName to align in the printed receipt later.
        switch(serialNo){
            case 1:
                itemName = "Burger       ";
                subtotal += pricesArray[0] * itemQuantity;
                break;
            case 2:
                itemName = "Pasta        ";
                subtotal += pricesArray[1] * itemQuantity;
                break;
            case 3:
                itemName = "Chicken Roast";
                subtotal += pricesArray[2] * itemQuantity;
                break;
            case 4:
                itemName = "Coffee       ";
                subtotal += pricesArray[3] * itemQuantity;
                break;
            case 5:
                itemName = "Water        ";
                subtotal += pricesArray[4] * itemQuantity;
                break;
            default:
                System.out.println("Please enter a valid number between 1 to 5.");
        }

        // Calculate sub-payment amount for each order entry
        float multipliedAmount= pricesArray[serialNo - 1] * itemQuantity;

        // Add order entry to ArrayList
        orderList.add(new OrderDetails(itemName, itemQuantity, multipliedAmount));
    }

    public void calculateTips(){
        float afterTax = 1.0675f * subtotal;
        tips = 0.10f * afterTax;
        float largerTax;

        // Prompt user for more tips

        System.out.println("The default mandatory 10% tips is " + String.format("$%.2f", tips));
        System.out.println("Would you like to give tips higher than this amount? (Yes/No, y/n)");

        while (true)
        {
            String promptTips = sc.nextLine().toLowerCase();

            if (promptTips.equals("yes") || promptTips.equals("y"))
            {
                do
                {
                    System.out.println("Please select a tax amount greater than " + String.format("$%.2f", tips));
                    while (!sc.hasNextFloat())
                    {
                        System.out.println("Please select a tax amount greater than " + String.format("$%.2f", tips));
                        sc.next();
                    }
                    largerTax = sc.nextFloat();
                    if (largerTax < tips)
                    {
                        System.out.println("Please select a tax amount greater than " + String.format("$%.2f", tips));
                    }
                }
                while (largerTax < tips);

                tips = largerTax;
                break;
            }
            if (promptTips.equals("no") || promptTips.equals("n"))
            {
                System.out.println("No problem, we'll give you the receipt now!");
                break;
            }
            else
            {
                System.out.println("Would you like to give tips higher than"
                        + String.format("$%.2f", tips) + "? (Yes/No, y/n)");
            }
        }

    }

    public void printBill(){
        System.out.println("This is your receipt:\n");
        System.out.println("Item Name         Quantity       Amount\n---------------------------------------------");
        //System.out.println(orderList + "\n");

        // Printing every single  ordered food from the ArrayList
        for (OrderDetails i: orderList){
            System.out.println(i);
        }

        // Calculate tax and print out the tax fee.
        tax = 0.0675f * subtotal;
        System.out.println("---------------------------------------------");
        System.out.println("Subtotal                         " + String.format("$%.2f", subtotal));
        System.out.println("Tax                              " + String.format("$%.2f", tax));
        System.out.println("Tips                             " + String.format("$%.2f", tips));

        // Calculate total bill
        float finalBill = subtotal + tax + tips;
        System.out.println("*********************************************");
        System.out.println("FINAL BILL                       " + String.format("$%.2f", finalBill));

    }
}

