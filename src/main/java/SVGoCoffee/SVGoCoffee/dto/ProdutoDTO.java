package SVGoCoffee.SVGoCoffee.dto;

import SVGoCoffee.SVGoCoffee.entities.Produto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;
    private String categoria;
    private String imagem;
    private Integer estoque;
    private boolean situacao;
    private String observacao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
        this.imagem = produto.getImagem();
        this.estoque = produto.getEstoque();
        this.observacao =produto.getObservacao();
        this.situacao = produto.isSituacao();
    }
    

    public Integer getEstoque() {
        return estoque;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagem() {
        return imagem;
    }

}