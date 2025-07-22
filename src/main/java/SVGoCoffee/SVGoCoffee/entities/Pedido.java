package SVGoCoffee.SVGoCoffee.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(nullable = false)
    private Integer mesa;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_mesa", nullable = false)
    private SituacaoMesa situacao;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private Integer pontos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Pedido() {
    }

    public Pedido(Long id, Date data, Integer mesa, SituacaoMesa situacao, Double valorTotal, String formaPagamento,
            Integer pontos, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.mesa = mesa;
        this.situacao = situacao;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.pontos = pontos;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}