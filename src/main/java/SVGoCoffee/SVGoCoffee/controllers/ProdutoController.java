package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.ProdutoDTO;
import SVGoCoffee.SVGoCoffee.dto.ProdutoRequestDTO;
import SVGoCoffee.SVGoCoffee.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        ProdutoDTO produtoDTO = produtoService.findById(id);
        return ResponseEntity.ok(produtoDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvar(@ModelAttribute ProdutoRequestDTO dto) throws IOException {
        ProdutoDTO novoProduto = produtoService.salvar(dto);
        return ResponseEntity.status(201).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto) throws IOException {
        ProdutoDTO produtoAtualizado = produtoService.update(id, dto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}