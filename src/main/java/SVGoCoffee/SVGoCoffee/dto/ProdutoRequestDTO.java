package SVGoCoffee.SVGoCoffee.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProdutoRequestDTO {
    private String nome;
    private Double preco;
    private String categoria;
    private MultipartFile imagem;

    

    public ProdutoRequestDTO(String nome, Double preco, String categoria, MultipartFile imagem) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.imagem = imagem;
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