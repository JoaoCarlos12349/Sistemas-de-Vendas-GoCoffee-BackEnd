
package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.ClienteDTO;
import SVGoCoffee.SVGoCoffee.entities.Cliente;
import SVGoCoffee.SVGoCoffee.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> findAll() {
        return repository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return new ClienteDTO(cliente);
    }

    public ClienteDTO insert(Cliente cliente) {
        cliente.setPontos(0);
        Cliente novo = repository.save(cliente);
        return new ClienteDTO(novo);
    }
}
