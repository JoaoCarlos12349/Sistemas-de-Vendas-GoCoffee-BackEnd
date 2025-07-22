package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.ItemPedidoDTO;
import SVGoCoffee.SVGoCoffee.entities.ItemPedido;
import SVGoCoffee.SVGoCoffee.entities.Pedido;
import SVGoCoffee.SVGoCoffee.entities.Produto;
import SVGoCoffee.SVGoCoffee.repositories.ItemPedidoRepository;
import SVGoCoffee.SVGoCoffee.repositories.PedidoRepository;
import SVGoCoffee.SVGoCoffee.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ItemPedidoDTO> listarTodos() {
        return itemPedidoRepository.findAll().stream()
                .map(ItemPedidoDTO::new)
                .collect(Collectors.toList());
    }

    public ItemPedidoDTO salvar(ItemPedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.getIdPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + dto.getIdPedido()));

        Produto produto = produtoRepository.findById(dto.getIdProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + dto.getIdProduto()));

        ItemPedido itemPedido = new ItemPedido();
        produto.setEstoque(produto.getEstoque() - dto.getQuantidade());
        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setSubtotal(dto.getSubtotal());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        ItemPedido salvo = itemPedidoRepository.save(itemPedido);
        produtoRepository.save(produto);
        return new ItemPedidoDTO(salvo);
    }

    public ItemPedidoDTO findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPedido não encontrado com ID: " + id));
        return new ItemPedidoDTO(itemPedido);
    }

    public ItemPedidoDTO update(Long id, ItemPedidoDTO dto) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPedido não encontrado com ID: " + id));

        Pedido pedido = pedidoRepository.findById(dto.getIdPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + dto.getIdPedido()));

        Produto produto = produtoRepository.findById(dto.getIdProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + dto.getIdProduto()));

        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setSubtotal(dto.getSubtotal());
        produto.setEstoque(produto.getEstoque() - dto.getQuantidade());
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        ItemPedido atualizado = itemPedidoRepository.save(itemPedido);
        produtoRepository.save(produto);
        return new ItemPedidoDTO(atualizado);
    }

    public void delete(Long id) {
        if (!itemPedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("ItemPedido não encontrado com ID: " + id);
        }
        itemPedidoRepository.deleteById(id);
    }
}