package org.example;

import javax.xml.ws.Endpoint;

public class EstoquePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9876/estoque", new EstoqueImpl());
        System.out.println("foi");
    }
}