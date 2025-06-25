
package SVGoCoffee.SVGoCoffee.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbResgatePontuacao")

public class ResgatePontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontosResgatados;

    private String tipoResgate;

    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
}
