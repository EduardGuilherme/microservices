package com.msclientes.MsClientes.application.representation;

import com.msclientes.MsClientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {
    private  String nome;
    private String cpf;
    private  Integer idade;

    public Cliente toModel(){
        return new Cliente(nome,cpf,idade);
    }
}
