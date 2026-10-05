package lw03.unguided;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Map<String, Integer> courses = new LinkedHashMap<>();
        List<String> courseOrder = new LinkedList<>();
        List<String> checks = new LinkedList<>();

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("enrollment.txt")
        );

        int rejected = 0;

        while (scanner.hasNextLine()) {

            String operation = scanner.next();

            String course = scanner.next();

            if (operation.equals("REGISTER")) {

                int count = scanner.nextInt();

                if (!courses.containsKey(course)) {

                    courses.put(course, count);
                    courseOrder.add(course);

                } else {

                    int current = courses.get(course);

                    courses.put(course, current + count);
                }

            } else if (operation.equals("WITHDRAW")) {

                int count = scanner.nextInt();

                if (courses.containsKey(course)) {

                    int current = courses.get(course);

                    if (current >= count) {

                        courses.put(course, current - count);

                    } else {

                        rejected++;
                    }

                } else {

                    rejected++;
                }

            } else if (operation.equals("CHECK")) {

                if (courses.containsKey(course)) {

                    int current = courses.get(course);

                    checks.add(
                        course + ": " + current + " students"
                    );

                } else {

                    checks.add(
                        course + ": Not found"
                    );

                    rejected++;
                }
            }
        }

        scanner.close();


        System.out.println("----- Enrollment Checks -----");

        for (String check : checks) {

            System.out.println(check);
        }


        System.out.println("\n----- Final Enrollment -----");

        for (String course : courseOrder) {

            System.out.println(
                course + ": " + courses.get(course) + " students"
            );
        }


        System.out.println(
            "\nRejected operations: " + rejected
        );
    }
}