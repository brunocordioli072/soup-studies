package org.example;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

public class TokenUsuario {
    private String token;
    private Date dataValidade;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}
