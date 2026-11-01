package lw04.prelab;

import java.util.Scanner;

public class Main {

    public static void insertionSort(int[] branches) {

        for (int i = 1; i <= 3; i++) {

            int key = branches[i];
            int j = i - 1;

            while (j >= 0 && branches[j] < key) {

                branches[j + 1] = branches[j];
                j--;
            }

            branches[j + 1] = key;
        }
    }


    public static int linearSearch(int[] branches, int target) {

        for (int i = 0; i < branches.length; i++) {

            if (branches[i] == target) {

                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("branches.txt")
        );

        int n = scanner.nextInt();

        int[] branches = new int[n];

        for (int i = 0; i < n; i++) {

            branches[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {

            targets[i] = scanner.nextInt();
        }

        scanner.close();

        insertionSort(branches);

        System.out.println("===== Sorting Result =====");

        for (int i = 0; i < branches.length; i++) {

            System.out.print(branches[i] + " ");
        }

        System.out.println();

        System.out.println("\n===== Searching Result =====");

        for (int i = 0; i < targets.length; i++) {

            int result = linearSearch(branches, targets[i]);

            if (result != -1) {

                System.out.println(
                    targets[i] + ": FOUND at index " + result
                );

            } else {

                System.out.println(
                    targets[i] + ": NOT FOUND"
                );
            }
        }
    }
}
