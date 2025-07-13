
package SVGoCoffee.SVGoCoffee.dto;

import java.time.LocalDateTime;

import SVGoCoffee.SVGoCoffee.entities.ResgatePontuacao;

public class ResgatePontuacaoDTO {
    private Long id;
    private Integer pontosResgatados;
    private String tipoResgate;
    private LocalDateTime data;
    private Long pessoa_id;

    public ResgatePontuacaoDTO() {
    }

    public ResgatePontuacaoDTO(ResgatePontuacao resgatePontuacao) {
        this.id = resgatePontuacao.getId();
        this.data = resgatePontuacao.getData();
        this.pessoa_id = resgatePontuacao.getPessoa().getId();
        this.pontosResgatados = resgatePontuacao.getPontosResgatados();
        this.tipoResgate = resgatePontuacao.getTipoResgate();
    }

    public Long getId() {
        return id;
    }

    public Integer getPontosResgatados() {
        return pontosResgatados;
    }

    public String getTipoResgate() {
        return tipoResgate;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Long getPessoa_id() {
        return pessoa_id;
    }

}
