package SVGoCoffee.SVGoCoffee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SVGoCoffee.SVGoCoffee.dto.UsuarioDTO;
import SVGoCoffee.SVGoCoffee.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UsuarioDTO findByLogin(String login);
}
