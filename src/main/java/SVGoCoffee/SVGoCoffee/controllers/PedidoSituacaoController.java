
package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.PedidoSituacaoDTO;
import SVGoCoffee.SVGoCoffee.services.PedidoSituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/situacoes-pedido")
public class PedidoSituacaoController {

    @Autowired
    private PedidoSituacaoService pedidoSituacaoService;

    @GetMapping
    public List<PedidoSituacaoDTO> listar() {
        return pedidoSituacaoService.listarTodos();
    }

    @PostMapping
    public PedidoSituacaoDTO salvar(@RequestBody PedidoSituacaoDTO dto) {
        return pedidoSituacaoService.salvar(dto);
    }
}
