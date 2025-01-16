package ua.edu.chmnu.network.java.server;

import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("The server is running, waiting for a connection...");

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Client is connected!");

                out.println("Hello! What's your name?");
                String name = in.readLine();
                System.out.println("The client named as: " + name);

                out.println("Let me guess your line of work. Enter your age:");
                String ageInput = in.readLine();
                int age = Integer.parseInt(ageInput);

                String activity;
                if (age <= 17) {
                    activity = "school student";
                } else if (age <= 25) {
                    activity = "university student";
                } else {
                    activity = "worker";
                }

                out.println("You are a " + activity);

                out.println("To exit, press 'Q' or type 'exit': ");
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}