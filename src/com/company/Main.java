package com.company;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

       Random rand = new Random(13);

       int[][] hashTable = new int[50][5];
       int[] overFlow = new int[50];


       for(int i=0; i<200;i++){
           int num = rand.nextInt(9998)+1;
           int index=num%50;
           int index2=0;

           
           hashTable[index][index2] = num;
       }

        for(int i=0;i<50;i++){
            for(int j=0; j<5;j++){
               System.out.print(hashTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}
