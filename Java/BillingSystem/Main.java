package com.shangce;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ClassMethods order = new ClassMethods();

        // Display menu for user
        order.menuDisplay();

        // Prompts user to key in order and continue doing so until user says no
        order.selectItems();

        // Calculates bill, prompt user for any higher tips input
        order.calculateTips();

        // Print the final bill
        order.printBill();

        }



}

