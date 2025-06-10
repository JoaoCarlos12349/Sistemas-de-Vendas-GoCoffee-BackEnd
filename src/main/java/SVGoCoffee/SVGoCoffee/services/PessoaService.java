package SVGoCoffee.SVGoCoffee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SVGoCoffee.SVGoCoffee.dto.PessoaDTO;
import SVGoCoffee.SVGoCoffee.entities.Pessoa;
import SVGoCoffee.SVGoCoffee.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> findAll() {
        List<Pessoa> listaUsuario = pessoaRepository.findAll();
        return listaUsuario.stream().map(PessoaDTO::new).toList();
    }

    public PessoaDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
        return new PessoaDTO(pessoa);
    }

    public PessoaDTO insert(PessoaDTO pessoaDTO) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSexo(pessoaDTO.getSexo());
        pessoa.setEndereco(pessoaDTO.getEndereco());
        pessoa.setPontuacao(Integer.valueOf(0));

        Pessoa pessoaSalvo = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaSalvo);
    }

    public PessoaDTO update(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSexo(pessoaDTO.getSexo());
        pessoa.setEndereco(pessoaDTO.getEndereco());

        if (pessoaDTO.getPontuacao() != null) {
            pessoa.setPontuacao(pessoaDTO.getPontuacao());
        }

        Pessoa pessoaAtualizado = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoaAtualizado);

    }

    public void delete(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa não encontrada com ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }
}
