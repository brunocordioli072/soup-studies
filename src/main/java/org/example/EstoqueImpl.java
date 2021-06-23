package org.example;

import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.example.Estoque")
public class EstoqueImpl implements Estoque {

    private ItemDao dao = new ItemDao();

    public ListaItens getItens(Filtros filtros) {
        System.out.println("Chamando getItens()");
        List<Filtro> lista = filtros.getFiltros();
        List<Item> itensResultado = dao.todosItens(lista);
        ListaItens listaItens = new ListaItens();
        listaItens.setItens(itensResultado);
        return listaItens;
    }

    public void cadastrarItem(Item item, TokenUsuario tokenUsuario) {
        System.out.println("Cadastrando item");
        dao.cadastrarItem(item);
    }

}
