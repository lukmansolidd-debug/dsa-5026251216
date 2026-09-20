package lw01.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<PrintJob> jobs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/lw01/prelab/jobs.txt"));

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(" ");

                String type = parts[0];
                String id = parts[1];
                int pages = Integer.parseInt(parts[2]);

                PrintJob job;

                if (type.equals("MONO")) {
                    job = new MonoPrint(id, pages);
                } else if (type.equals("COLOUR")) {
                    job = new ColourPrint(id, pages);
                } else {
                    throw new IllegalArgumentException("Invalid print type");
                }

                jobs.add(job);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("jobs.txt not found.");
        }

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}