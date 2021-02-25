package com.anonymous;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

            DataInputStream inputStream = new DataInputStream(serverSocket.getInputStream());
            System.out.printf("Client Says, \n \"%s\"", inputStream.readUTF());

            DataOutputStream outputStream = new DataOutputStream(serverSocket.getOutputStream());
            outputStream.writeUTF(String.format("Hello, thank you for connecting to %s, what exactly do you want?", serverSocket.getLocalSocketAddress()));

            serverSocket.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
