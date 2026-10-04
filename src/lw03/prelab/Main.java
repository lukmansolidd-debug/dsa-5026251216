package lw03.prelab;

import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        List<String> playlist = new ArrayList<>();

        Scanner playlistScanner = new Scanner(
            Main.class.getResourceAsStream("playlist.txt")
        );

        while (playlistScanner.hasNextLine()) {

            String line = playlistScanner.nextLine();
            String[] data = line.split(" ");

            if (data[0].equals("ADD")) {

                playlist.add(data[1]);

            } else if (data[0].equals("INSERT")) {

                int index = Integer.parseInt(data[1]);
                playlist.add(index, data[2]);

            } else if (data[0].equals("REMOVE")) {

                if (playlist.contains(data[1])) {
                    playlist.remove(data[1]);
                }
            }
        }

        playlistScanner.close();


        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {

            System.out.println(
                (i + 1) + ": " + playlist.get(i)
            );
        }


        Set<String> participants = new LinkedHashSet<>();

        Scanner participantScanner = new Scanner(
            Main.class.getResourceAsStream("participants.txt")
        );

        int duplicate = 0;

        while (participantScanner.hasNextLine()) {

            String name = participantScanner.nextLine();

            if (participants.contains(name)) {

                duplicate++;

            } else {

                participants.add(name);
            }
        }

        participantScanner.close();


        System.out.println("\n===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String participant : participants) {

            System.out.println(
                number + ". " + participant
            );

            number++;
        }

        System.out.println("Duplicate registrations: " + duplicate);

        Map<String, Integer> inventory = new LinkedHashMap<>();

        Scanner inventoryScanner = new Scanner(
            Main.class.getResourceAsStream("inventory.txt")
        );

        int failedSales = 0;

        while (inventoryScanner.hasNextLine()) {

            String type = inventoryScanner.next();
            String product = inventoryScanner.next();
            int quantity = inventoryScanner.nextInt();

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);
                    inventory.put(product, stock + quantity);

                } else {

                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);

                    if (stock >= quantity) {

                        inventory.put(product, stock - quantity);

                    } else {

                        failedSales++;
                    }

                } else {

                    failedSales++;
                }
            }
        }

        inventoryScanner.close();


        System.out.println("\n===== Problem 3 =====");

        for (String product : inventory.keySet()) {

            System.out.println(
                product + ": " + inventory.get(product)
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}