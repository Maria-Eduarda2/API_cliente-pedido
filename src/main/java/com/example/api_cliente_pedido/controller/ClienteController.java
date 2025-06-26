package com.example.api_cliente_pedido.controller;

import com.example.api_cliente_pedido.model.Cliente;
import com.example.api_cliente_pedido.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Transforma retornos em JSON.
@RequestMapping("/clientes") // Define o caminho base para todos os endpoints do controlador
public class ClienteController {

    @Autowired // Injeta automaticamente o repositório no controlador
    private ClienteRepository clienteRepository;

    // CREATE - Criar um novo cliente
    @PostMapping // Mapeia requisições HTTP POST para o metodo
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // READ - Listar todos os clientes
    @GetMapping //Mapeia requisições HTTP GET.
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // READ - Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) { // Extrai valores da URL
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Atualizar um cliente
    @PutMapping("/{id}") //Mapeia requisições HTTP PUT.
    public ResponseEntity<Cliente> atualizarCliente(
            @PathVariable Integer id,
            @RequestBody Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    Cliente updated = clienteRepository.save(cliente);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Remover um cliente
    @DeleteMapping("/{id}") // Mapeia requisições HTTP DELETE.
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}