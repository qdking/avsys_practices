package com.shangce;

import java.text.DecimalFormat;

// The order details blueprint to be printed for every instance of order entry being printed out
public class OrderDetails {

    private String itemName;
    private int itemQuantity;
    private float multipliedAmount;

    public OrderDetails(String itemName, int itemQuantity, float multipliedAmount)
    {
        super();
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.multipliedAmount = multipliedAmount;
    }

    // Override toString method to return a String value whenever OrderDetails is called
    @Override
    public String toString() {
        return (itemName + "        " + itemQuantity + "         "  + String.format("  $%.2f", multipliedAmount));
    }
}
