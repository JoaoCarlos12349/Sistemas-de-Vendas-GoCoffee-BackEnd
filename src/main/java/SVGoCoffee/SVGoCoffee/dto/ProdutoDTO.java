package SVGoCoffee.SVGoCoffee.dto;

import org.springframework.web.multipart.MultipartFile;

import SVGoCoffee.SVGoCoffee.entities.Produto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;
    private String categoria;
    private String imagem;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
        this.imagem = produto.getImagem();
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