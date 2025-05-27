package com.msclientes.MsClientes.application;

import com.msclientes.MsClientes.application.representation.ClienteSaveRequest;
import com.msclientes.MsClientes.application.service.ClienteService;
import com.msclientes.MsClientes.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("clientes")
public class ClientesResource {

    private final ClienteService service;

    public ClientesResource(ClienteService service) {
        this.service = service;
    }


    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save (@RequestBody ClienteSaveRequest request){
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = service.getbyCPF(cpf);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
