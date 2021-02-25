package com.anonymous;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleServer {


    private static final int PORT = 8005;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);

            System.out.printf("Waiting for client on port, %d...\n", server.getLocalPort());

            Socket serverSocket = server.accept();

            System.out.printf("Just Connected to %s\n", serverSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new DataInputStream(serverSocket.getInputStream())
                    )
            );

            System.out.println("Client Says,");

            System.out.println(in.readLine());

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new DataOutputStream(serverSocket.getOutputStream())
                            )
                    )
            );

            out.write(String.format("Hello, thank you for connecting to %s, what exactly do you want?", serverSocket.getLocalSocketAddress()));
            out.flush();

            serverSocket.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
