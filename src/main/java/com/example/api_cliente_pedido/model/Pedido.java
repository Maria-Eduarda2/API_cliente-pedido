package com.example.api_cliente_pedido.model;

import jakarta.persistence.*;

@Entity // essa classe é uma entidade do BD
@Table(name = "pedidos") // nome da tabela
public class Pedido {

    @Id // indica que é chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que é auto - increment
    private Integer id;

    @Column(nullable = false) // não p0de ser nulo
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // Chave estrangeira
    private Cliente cliente; // Relação N-1 com Cliente

    // Construtor vazio (obrigatório para o JPA) para criar instâncias da entidade.
    public Pedido() {}

    // Get e Set
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
