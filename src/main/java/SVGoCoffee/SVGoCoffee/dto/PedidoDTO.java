package SVGoCoffee.SVGoCoffee.dto;

import java.time.LocalDateTime;
import SVGoCoffee.SVGoCoffee.entities.Pedido;
import SVGoCoffee.SVGoCoffee.entities.SituacaoMesa;

public class PedidoDTO {

    private Long id;
    private LocalDateTime data;
    private Integer mesa;
    private SituacaoMesa situacao;
    private Double valorTotal;
    private Integer pontos;
    private Long usuario_id;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.mesa = pedido.getMesa();
        this.situacao = pedido.getSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.pontos = pedido.getPontos();
        if (pedido.getUsuario() != null) {
            this.usuario_id = pedido.getUsuario().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public SituacaoMesa getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoMesa situacao) {
        this.situacao = situacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}