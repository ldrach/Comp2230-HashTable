package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Initializes Random Number and Arrays
        Random rand = new Random(13);
        HashTable table = new HashTable();

        for (int i = 0; i < 200; i++) {
            int num = rand.nextInt(9998) + 1;
            table.add(num);
        }

        table.showArray();
        //removes the first number in a full row
        table.remove(3820);
        //removes the only number from a row
        table.remove(1334);
        //removes number from overflow
        table.remove(50);
        //removes a number added to hashtable from overflow
        table.remove(9308);
        //removes a number not in the overflow or hashtable
        table.remove(1000000);

        table.showArray();
    }
}
