package com.company;

public class HashTable {

    int[][] hashTable = new int[50][5];
    int[] overFlow = new int[50];

    //Initializes all array values to -1
    public HashTable() {
        for (int r = 0; r < 50; r++) {
            overFlow[r] = -1;
            for (int c = 0; c < 5; c++) {
                hashTable[r][c] = -1;
            }
        }
    }

    //adds a number to the hash table or overflow if all columns are full
    public void add(int number) {
        int col = 0;
        int row = number % 49;

        while ((col < 5) && hashTable[row][col] != -1) {
            col++;
        }

        if (col < 5) {
            hashTable[row][col] = number;
        } else {
            int index = 0;
            while ((overFlow[index] != -1) && index < 50) {
                index++;
            }
            if (index < 50) {
                overFlow[index] = number;
            } else {
                System.out.println("The Overflow Table Is Full!!");
            }
        }
    }

    public void remove(int number) {
        int col = 0;
        int row = number % 49;

        //searches each column in the row of the Hash Table for the given value
        while (col < 5) {
            if (hashTable[row][col] == number) {
                hashTable[row][col] = -1;
                break;
            }
            col++;
        }

        //Not in main hash table, moves to overflow
        if (col == 5) {
            int index = 0;
            while ((index < 50) && overFlow[index] != number) {
                index++;
            }
            if (index < 50) {
                overFlow[index] = -1;
                int current = index;
                int next = index + 1;
                while (current < 49) {
                    overFlow[current] = overFlow[next];
                    overFlow[next] = -1;
                    current++;
                    next++;
                }

            } else {
                System.out.println("Value: " + number + " is not present in HashTable or OverFlow");
            }
        }
        //found in HashTable
        else {
            int current = 0;
            int next = 1;
            while (current < 4) {
                if (hashTable[row][current] == -1) {
                    hashTable[row][current] = hashTable[row][next];
                    hashTable[row][next] = -1;
                }
                current++;
                next++;
            }
            //Finds a value in the overflow to move to hash table
            for (int i = 0; i < 5; i++) {
                if (hashTable[row][i] == -1) {
                    int j = 0;
                    while (j < 50) {
                        if (overFlow[j] % 49 == row) {
                            hashTable[row][i] = overFlow[j];
                            overFlow[j] = -1;
                            current = j;
                            next = j + 1;
                            while (current < 49) {
                                overFlow[current] = overFlow[next];
                                overFlow[next] = -1;
                                current++;
                                next++;
                            }
                        } else
                            j++;
                    }
                }
            }
        }
    }

    //Prints both arrays
    public void showArray() {
        System.out.println("Hash Table");
        for (int row = 0; row < 50; row++) {
            for (int col = 0; col < 5; col++) {
                if (hashTable[row][col] == -1)
                    System.out.print("Empty" + " ");
                else
                    System.out.print(hashTable[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("Overflow");
        for (int i = 0; i < 50; i++) {
            if (overFlow[i] == -1)
                System.out.print("Empty" + " ");
            else
                System.out.print(overFlow[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}

