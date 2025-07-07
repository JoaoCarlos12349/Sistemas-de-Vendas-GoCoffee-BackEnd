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

    public Long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public Double getPreco() {
        throw new UnsupportedOperationException("Unimplemented method 'getPreco'");
    }

    public String getCategoria() {
        throw new UnsupportedOperationException("Unimplemented method 'getCategoria'");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }
}
