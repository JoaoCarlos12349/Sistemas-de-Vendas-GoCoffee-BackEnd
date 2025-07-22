package SVGoCoffee.SVGoCoffee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SVGoCoffee.SVGoCoffee.dto.PessoaDTO;
import SVGoCoffee.SVGoCoffee.services.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) throws Exception {
        PessoaDTO pessoaNovo = pessoaService.insert(pessoaDTO);
        return ResponseEntity.status(201).body(pessoaNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) throws Exception {
        PessoaDTO pessoaAtualizado = pessoaService.update(id, pessoaDTO);
        return ResponseEntity.ok(pessoaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
