package com.example.api_cliente_pedido.model;
import jakarta.persistence.*;
import java.util.List;

@Entity // essa classe é uma entidade do BD
@Table(name = "clientes") // Nome da tabela
public class Cliente {

    @Id // indica que é chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que é auto - increment
    private Integer id;

    @Column(nullable = false) // não pode ser nulo
    private String nome;

//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//    private List<Pedido> pedidos; // Relação 1-N com Pedido

    // Construtor vazio (obrigatório para o JPA) para criar instâncias da entidade.
    public Cliente() {}

    // Get e Set
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

//    public List<Pedido> getPedidos() { return pedidos; }
//    public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
}
