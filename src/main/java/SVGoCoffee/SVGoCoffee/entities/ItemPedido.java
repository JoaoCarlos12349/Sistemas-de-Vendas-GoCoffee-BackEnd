package SVGoCoffee.SVGoCoffee.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbItemPedido")

public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
}
