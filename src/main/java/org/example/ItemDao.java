package org.example;

import org.example.Filtro;
import org.example.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemDao {

    // gera uma lista de 30 itens com seus respectivos filtros aleatorios
    public List<Item> todosItens(List<Filtro> filtros) {
        List<Item> items = new ArrayList<>();
        Random randomizer = new Random();
        List<Filtro.TipoItem> tipoItems = Arrays.asList(Filtro.TipoItem.Celular, Filtro.TipoItem.Tablet, Filtro.TipoItem.Livro);
        for (int i = 0; i < 30; i++) {
            Filtro.TipoItem random = tipoItems.get(randomizer.nextInt(tipoItems.size()));
            Item item = new Item();
            item.setTipoItem(random);
            items.add(item);
        }

        // filtra os itens criados pelo TipoItem recebido no parametro filtros
        List<Item> filteredItens = items.stream().filter(item ->
                filtros.stream().filter(filtro ->
                        filtro.getTipoItem() == item.getTipoItem()).count() > 0)
                .collect(Collectors.toList());
        return filteredItens;
    }
}
