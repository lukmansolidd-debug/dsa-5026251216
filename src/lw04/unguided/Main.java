package lw04.unguided;

import java.util.Scanner;

public class Main {

    public static void selectionSort(int[] cards, int passes) {

        for (int i = 0; i < passes; i++) {

            int idx = i;

            for (int j = i + 1; j < cards.length; j++) {

                if (cards[j] < cards[idx]) {

                    idx = j;
                }
            }

            int temp = cards[i];
            cards[i] = cards[idx];
            cards[idx] = temp;
        }
    }


    public static int linearSearch(int[] cards, int target) {

        for (int i = 0; i < cards.length; i++) {

            if (cards[i] == target) {

                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("cards.txt")
        );

        int n = scanner.nextInt();

        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {

            cards[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {

            targets[i] = scanner.nextInt();
        }

        scanner.close();

        selectionSort(cards, 2);

        for (int i = 0; i < cards.length; i++) {

            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(cards[i]);
        }

        System.out.println();

        for (int i = 0; i < targets.length; i++) {

            int result = linearSearch(cards, targets[i]);

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
