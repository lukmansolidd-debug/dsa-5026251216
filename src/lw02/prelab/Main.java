package lw02.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<String[]> transactionList = new LinkedList<>();
        LinkedList<String[]> customerList = new LinkedList<>();

        File file = new File("src/lw02/prelab/transactions.txt");
        Scanner input = new Scanner(file);

        // Membaca transaksi dari file
        while (input.hasNext()) {

            String customerName = input.next();
            String transactionType = input.next();
            String transactionAmount = input.next();

            String[] transaction = {
                    customerName,
                    transactionType,
                    transactionAmount
            };

            transactionList.add(transaction);

            // Mengecek apakah customer sudah ada
            boolean found = false;

            for (String[] customer : customerList) {
                if (customer[0].equals(customerName)) {
                    found = true;
                    break;
                }
            }

            // Jika belum ada, tambahkan customer dengan saldo awal 0
            if (!found) {
                String[] newCustomer = {
                        customerName,
                        "0"
                };

                customerList.add(newCustomer);
            }
        }

        input.close();

        // Memasukkan transaksi ke Queue
        Queue<String[]> transactionQueue = new LinkedList<>();

        while (!transactionList.isEmpty()) {
            String[] transaction = transactionList.removeFirst();
            transactionQueue.offer(transaction);
        }

        // Menyimpan transaksi withdrawal yang gagal
        Stack<String[]> failedStack = new Stack<>();

        // Memproses transaksi berdasarkan FIFO
        while (!transactionQueue.isEmpty()) {

            String[] currentTransaction = transactionQueue.poll();

            String customerName = currentTransaction[0];
            String transactionType = currentTransaction[1];
            int amount = Integer.parseInt(currentTransaction[2]);

            // Mencari customer
            for (String[] customer : customerList) {

                if (customer[0].equals(customerName)) {

                    int balance = Integer.parseInt(customer[1]);

                    if (transactionType.equals("DEPOSIT")) {

                        balance = balance + amount;
                        customer[1] = Integer.toString(balance);

                    } else if (transactionType.equals("WITHDRAW")) {

                        if (amount <= balance) {

                            balance = balance - amount;
                            customer[1] = Integer.toString(balance);

                        } else {

                            failedStack.push(currentTransaction);
                        }
                    }

                    break;
                }
            }
        }

        // Menampilkan saldo akhir setiap customer
        System.out.println("=== Final Balances ===");

        for (String[] customer : customerList) {
            System.out.println(
                    customer[0] + " : " + customer[1]
            );
        }

        // Menampilkan transaksi withdrawal yang gagal
        System.out.println("=== Failed Transactions ===");

        while (!failedStack.empty()) {

            String[] transaction = failedStack.pop();

            System.out.println(
                    transaction[0] + " "
                            + transaction[1] + " "
                            + transaction[2]
            );
        }
    }
}