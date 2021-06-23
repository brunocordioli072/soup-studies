package org.example;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface Estoque {

    @WebMethod(operationName="todosOsItens")
    ListaItens getItens(@WebParam(name="filtros") Filtros filtros);

    @Oneway
    @WebMethod(operationName="cadastrarItem")
    void cadastrarItem(@WebParam(name="item") Item item, @WebParam(mode = WebParam.Mode.IN) TokenUsuario tokenUsuario);

}