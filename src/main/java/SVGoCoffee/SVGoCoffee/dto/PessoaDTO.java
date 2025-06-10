package SVGoCoffee.SVGoCoffee.dto;

import SVGoCoffee.SVGoCoffee.entities.Pessoa;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String sexo;
    private String endereco;
    private Integer pontuacao;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.sexo = pessoa.getSexo();
        this.endereco = pessoa.getEndereco();
        this.pontuacao = pessoa.getPontuacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

}
