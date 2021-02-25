package com.anonymous;

import java.io.*;
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
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new DataOutputStream(socket.getOutputStream())
                            )
                    )
            );

            out.write(String.format("Hello %s, I need something\n", socket.getLocalSocketAddress()));
            out.flush();

            //Reading servers message
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new DataInputStream(socket.getInputStream())
                    )
            );

            System.out.println("Server Says,");

            System.out.println(in.readLine());


        } catch (IOException exception) {

            exception.printStackTrace();

        }

    }
}
