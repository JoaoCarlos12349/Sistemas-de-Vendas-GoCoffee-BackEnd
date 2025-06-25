package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.ProdutoDTO;
import SVGoCoffee.SVGoCoffee.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")

public interface ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listar() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public ProdutoDTO salvar(@RequestBody ProdutoDTO dto) {
        return produtoService.salvar(dto);
    }
}
