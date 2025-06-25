package SVGoCoffee.SVGoCoffee.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SVGoCoffee.SVGoCoffee.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin (String login);
}
