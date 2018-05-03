package ua.com.gurskaya.client.service;

import java.io.*;
import java.net.Socket;

public class Client {
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        Socket socket = null;
        BufferedReader input = null;
        BufferedWriter output = null;
        BufferedReader userEntry = null;
        String clientInput;
        String serverInput;
        try {
            socket = new Socket(host, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            userEntry = new BufferedReader(new InputStreamReader(System.in));

            while ((clientInput = userEntry.readLine()) != null) {

                output.write(clientInput);
                output.newLine();
                output.flush();

                serverInput = input.readLine();
                System.out.println(serverInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
                userEntry.close();
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

