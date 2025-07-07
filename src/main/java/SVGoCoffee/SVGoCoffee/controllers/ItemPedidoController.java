
package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.ItemPedidoDTO;
import SVGoCoffee.SVGoCoffee.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedidoDTO> listar() {
        return itemPedidoService.listarTodos();
    }

    @PostMapping
    public ItemPedidoDTO salvar(@RequestBody ItemPedidoDTO dto) {
        return itemPedidoService.salvar(dto);
    }
}
