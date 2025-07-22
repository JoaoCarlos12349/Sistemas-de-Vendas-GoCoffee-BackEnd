package SVGoCoffee.SVGoCoffee.dto;

import java.sql.Date;
import SVGoCoffee.SVGoCoffee.entities.Pedido;
import SVGoCoffee.SVGoCoffee.entities.SituacaoMesa;

public class PedidoDTO {

    private Long id;
    private String data;
    private Integer mesa;
    private SituacaoMesa situacao;
    private Double valorTotal;
    private Integer pontos;
    private Long usuario_id;
    private String formaPagamento;

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
        this.formaPagamento = pedido.getFormaPagamento();
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Integer getMesa() {
        return mesa;
    }

    public SituacaoMesa getSituacao() {
        return situacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Integer getPontos() {
        return pontos;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
    

   
}