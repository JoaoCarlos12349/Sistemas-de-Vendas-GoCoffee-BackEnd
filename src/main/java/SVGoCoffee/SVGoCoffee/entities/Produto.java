package SVGoCoffee.SVGoCoffee.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbProduto")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    private String categoria;
}
