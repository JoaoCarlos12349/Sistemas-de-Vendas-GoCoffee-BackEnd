
package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.PedidoSituacaoDTO;
import SVGoCoffee.SVGoCoffee.entities.PedidoSituacao;
import SVGoCoffee.SVGoCoffee.entities.Usuario;
import SVGoCoffee.SVGoCoffee.repositories.PedidoSituacaoRepository;
import SVGoCoffee.SVGoCoffee.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoSituacaoService {

    @Autowired
    private PedidoSituacaoRepository pedidoSituacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<PedidoSituacaoDTO> listarTodos() {
        return pedidoSituacaoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoSituacaoDTO salvar(PedidoSituacaoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        PedidoSituacao situacao = new PedidoSituacao();
        situacao.setData(LocalDateTime.now());
        situacao.setSituacao(dto.getSituacao());
        situacao.setUsuario(usuario);

        PedidoSituacao salvo = pedidoSituacaoRepository.save(situacao);
        return toDTO(salvo);
    }

    private PedidoSituacaoDTO toDTO(PedidoSituacao ps) {
        return new PedidoSituacaoDTO(ps.getId(), ps.getData(), ps.getSituacao(), ps.getUsuario().getId());
    }
}
