package org.example;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url= new URL("http://127.0.0.1:9876/calc?wsdl");
        QName qname = new QName("http://example.org/","CalculadoraServerImplService");
        Service ws = Service.create(url, qname);
        CalculadoraServer calc= ws.getPort(CalculadoraServer.class);

        System.out.println("Soma (5+1): " + calc.soma(5,1));
        System.out.println("Subtracao (5-1): " + calc.subtracao(5,1));
        System.out.println("Multiplicacao (5*1): " + calc.multiplicacao(5,1));
        System.out.println("Divisao (5/1): " + calc.divisao(5,1));
    }
}
