package com.anonymous;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SampleClient {

    private static final String SERVER_NAME = "localhost";
    private static final int PORT = 8005;

    public static void main(String[] args) {

        System.out.printf("Trying to connect to %s on port %d ...\n", SERVER_NAME, PORT);

        try {

            Socket socket = new Socket(SERVER_NAME, PORT);

            System.out.println("Just connected");

            //Writing Message to the server
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(String.format("Hello %s, I need something", socket.getLocalSocketAddress()));

            //Reading servers message
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.printf("Server says, %s \n", inputStream.readUTF());

        } catch (IOException exception) {

            exception.printStackTrace();

        }

    }
}
