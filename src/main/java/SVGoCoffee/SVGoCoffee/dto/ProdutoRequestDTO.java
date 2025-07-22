package SVGoCoffee.SVGoCoffee.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProdutoRequestDTO {
    private String nome;
    private Double preco;
    private String categoria;
    private MultipartFile imagem;
    private Integer estoque;
    private boolean situacao;
    private String observacao;

    public Integer getEstoque() {
        return estoque;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public ProdutoRequestDTO(String nome, Double preco, String categoria, MultipartFile imagem, Integer estoque,
            boolean situacao, String observacao) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.imagem = imagem;
        this.estoque = estoque;
        this.observacao = observacao;
        this.situacao = situacao;
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

    public MultipartFile getImagem() {
        return imagem;
    }

}