
package SVGoCoffee.SVGoCoffee.repositories;

import SVGoCoffee.SVGoCoffee.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
