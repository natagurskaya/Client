package ua.com.gurskaya.client.controller;

import ua.com.gurskaya.client.service.Client;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 8080);
        client.start();
    }
}
