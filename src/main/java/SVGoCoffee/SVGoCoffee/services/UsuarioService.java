
package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.UsuarioDTO;
import SVGoCoffee.SVGoCoffee.entities.Pessoa;
import SVGoCoffee.SVGoCoffee.entities.Usuario;
import SVGoCoffee.SVGoCoffee.repositories.PessoaRepository;
import SVGoCoffee.SVGoCoffee.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO insert(UsuarioDTO usuarioDTO) {

        Pessoa pessoa = pessoaRepository.findById(usuarioDTO.getPessoa_id())
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Cliente não encontrado com ID: " + usuarioDTO.getPessoa_id()));

        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setPessoa(pessoa);
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuarioSalvo);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));

        Pessoa pessoa = pessoaRepository.findById(usuarioDTO.getPessoa_id())
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Cliente não encontrado com ID: " + usuarioDTO.getPessoa_id()));

        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setPessoa(pessoa);
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuarioAtualizado);

    }

    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Pedido não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
