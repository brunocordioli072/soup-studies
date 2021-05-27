package org.example;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EstoqueClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url= new URL("http://127.0.0.1:9876/estoque?wsdl");
        QName qname = new QName("http://example.org/","EstoqueImplService");
        Service ws = Service.create(url, qname);
        Estoque estoque = ws.getPort(Estoque.class);

        Filtros filtros = new Filtros();
        Filtro filtro = new Filtro();
        Random randomizer = new Random();

        // Para deixar um pouco menos repetitivo fiz com que fosse aleatorio o tipo de filtro que é escolhido
        List<Filtro.TipoItem> tipoItems = Arrays.asList(Filtro.TipoItem.Celular, Filtro.TipoItem.Tablet, Filtro.TipoItem.Livro);
        filtro.setTipoItem(tipoItems.get(randomizer.nextInt(tipoItems.size())));

        filtros.setFiltros(Arrays.asList(filtro));
        ListaItens item = estoque.getItens(filtros);
        System.out.println("Filtro escolhido: " + filtro.getTipoItem());
        System.out.println("Quantidade de itens: " + item.getItens().size());
        item.getItens().stream().forEach(i -> {
            System.out.println("Item tipo: "+ i.getTipoItem());
        });
    }
}