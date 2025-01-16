package ua.edu.chmnu.network.java.client;

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connecting to the server...");

            System.out.println(in.readLine());

            System.out.print("Enter your name: ");
            String name = userInput.readLine();
            out.println(name);

            System.out.println(in.readLine());

            System.out.print("Enter your age: ");
            String age = userInput.readLine();
            out.println(age);

            System.out.println(in.readLine());

            System.out.println(in.readLine());

            String command = userInput.readLine();
            if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("exit")) {
                System.out.println("Termination of client...");
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}