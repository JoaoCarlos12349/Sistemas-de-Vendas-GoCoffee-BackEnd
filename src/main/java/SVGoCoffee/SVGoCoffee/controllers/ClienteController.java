package SVGoCoffee.SVGoCoffee.controllers;

import SVGoCoffee.SVGoCoffee.dto.ClienteDTO;
import SVGoCoffee.SVGoCoffee.entities.Cliente;
import SVGoCoffee.SVGoCoffee.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClienteDTO insert(@RequestBody Cliente cliente) {
        return service.insert(cliente);
    }
}
