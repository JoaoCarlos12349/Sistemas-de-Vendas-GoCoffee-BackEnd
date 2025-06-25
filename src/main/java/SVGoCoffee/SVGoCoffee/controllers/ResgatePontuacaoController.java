package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.ResgatePontuacaoDTO;
import SVGoCoffee.SVGoCoffee.services.ResgatePontuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resgates")
public class ResgatePontuacaoController {

    @Autowired
    private ResgatePontuacaoService resgatePontuacaoService;

    @GetMapping
    public List<ResgatePontuacaoDTO> listar() {
        return resgatePontuacaoService.listarTodos();
    }

    @PostMapping
    public ResgatePontuacaoDTO salvar(@RequestBody ResgatePontuacaoDTO dto) {
        return resgatePontuacaoService.salvar(dto);
    }
}
