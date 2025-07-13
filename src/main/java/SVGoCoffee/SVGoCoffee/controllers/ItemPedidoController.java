
package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.ItemPedidoDTO;
import SVGoCoffee.SVGoCoffee.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> findById(@PathVariable Long id) {
        ItemPedidoDTO itemPedidoDTO = itemPedidoService.findById(id);
        return ResponseEntity.ok(itemPedidoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoDTO>> findAll() {
        List<ItemPedidoDTO> itensPedidos = itemPedidoService.listarTodos();
        return ResponseEntity.ok(itensPedidos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDTO> create(@RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoDTO itemPedidoNovo = itemPedidoService.salvar(itemPedidoDTO);
        return ResponseEntity.status(201).body(itemPedidoNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> update(@PathVariable Long id, @RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoDTO itemPedidoAtualizado = itemPedidoService.update(id, itemPedidoDTO);
        return ResponseEntity.ok(itemPedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
