package SVGoCoffee.SVGoCoffee.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbPedidoSituacao")

public class PedidoSituacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    private String situacao;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
