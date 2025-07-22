package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.UsuarioDTO;
import SVGoCoffee.SVGoCoffee.entities.Pessoa;
import SVGoCoffee.SVGoCoffee.entities.TipoUsuario;
import SVGoCoffee.SVGoCoffee.entities.Usuario;
import SVGoCoffee.SVGoCoffee.repositories.PessoaRepository;
import SVGoCoffee.SVGoCoffee.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private PessoaRepository pessoaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {

        Pessoa pessoa = pessoaRepository.findById(usuarioDTO.getPessoa_id())
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Pessoa não encontrada com ID: " + usuarioDTO.getPessoa_id()));

        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setTipoUsuario(TipoUsuario.valueOf(usuarioDTO.getTipoUsuario()));

        usuario.setPessoa(pessoa);

        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        usuario.setLogin(usuarioDTO.getLogin());

        if (usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().isEmpty()) {
            usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        }
        usuario.setTipoUsuario(TipoUsuario.valueOf(usuarioDTO.getTipoUsuario()));

        return usuarioRepository.save(usuario);

    }

    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}