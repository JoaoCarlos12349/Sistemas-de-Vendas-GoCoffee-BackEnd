package SVGoCoffee.SVGoCoffee.dto;

import SVGoCoffee.SVGoCoffee.entities.ItemPedido;

public class ItemPedidoDTO {
    private Long id;
    private Integer quantidade;
    private Double subtotal;
    private Long idPedido;
    private Long idProduto;

    public ItemPedidoDTO() {
    }

    public ItemPedidoDTO(Long id, Integer quantidade, Double subtotal, Long idPedido, Long idProduto) {
        this.id = id;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    public ItemPedidoDTO(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.quantidade = itemPedido.getQuantidade();
        this.subtotal = itemPedido.getSubtotal();
        if (itemPedido.getPedido() != null) {
            this.idPedido = itemPedido.getPedido().getId();
        }
        if (itemPedido.getProduto() != null) {
            this.idProduto = itemPedido.getProduto().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}