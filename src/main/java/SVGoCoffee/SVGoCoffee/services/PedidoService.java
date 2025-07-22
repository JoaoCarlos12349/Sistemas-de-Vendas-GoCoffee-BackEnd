package SVGoCoffee.SVGoCoffee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SVGoCoffee.SVGoCoffee.dto.PedidoDTO;
import SVGoCoffee.SVGoCoffee.entities.Pedido;
import SVGoCoffee.SVGoCoffee.entities.SituacaoMesa;
import SVGoCoffee.SVGoCoffee.entities.Usuario;
import SVGoCoffee.SVGoCoffee.repositories.PedidoRepository;
import SVGoCoffee.SVGoCoffee.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<PedidoDTO> findAll() {
        List<Pedido> listaPedidos = pedidoRepository.findAll();
        return listaPedidos.stream().map(PedidoDTO::new).toList();
    }

    public PedidoDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + id));
        return new PedidoDTO(pedido);
    }

    public PedidoDTO insert(PedidoDTO pedidoDTO) {

        Usuario usuario = usuarioRepository.findById(pedidoDTO.getUsuario_id())
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Usuario não encontrado com ID: " + pedidoDTO.getUsuario_id()));

        Pedido pedido = new Pedido();
        pedido.setData(pedidoDTO.getData());
        pedido.setMesa(pedidoDTO.getMesa());
        pedido.setUsuario(usuario);
        pedido.setPontos(pedidoDTO.getPontos());
        pedido.setFormaPagamento(pedidoDTO.getFormaPagamento());

        // Pedido começa sempre esperando confirmação dos funcionários para produção
        pedido.setSituacao(SituacaoMesa.EsperandoConfirmacao);
        pedido.setValorTotal(pedidoDTO.getValorTotal());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return new PedidoDTO(pedidoSalvo);
    }

    public PedidoDTO update(Long id, PedidoDTO pedidoDTO) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + id));

        Usuario usuario = usuarioRepository.findById(pedidoDTO.getUsuario_id())
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Usuario não encontrado com ID: " + pedidoDTO.getUsuario_id()));



        pedido.setData(pedidoDTO.getData());
        pedido.setMesa(pedidoDTO.getMesa());
        pedido.setUsuario(usuario);
        pedido.setPontos(pedidoDTO.getPontos());
        pedido.setSituacao(pedidoDTO.getSituacao());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setFormaPagamento(pedidoDTO.getFormaPagamento());

        Pedido pedidoAtualizado = pedidoRepository.save(pedido);
        return new PedidoDTO(pedidoAtualizado);

    }

    public void delete(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pedido não encontrado com ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }

}
