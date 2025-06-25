
package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.ResgatePontuacaoDTO;
import SVGoCoffee.SVGoCoffee.entities.Pessoa;
import SVGoCoffee.SVGoCoffee.entities.ResgatePontuacao;
import SVGoCoffee.SVGoCoffee.repositories.PessoaRepository;
import SVGoCoffee.SVGoCoffee.repositories.ResgatePontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResgatePontuacaoService {

    @Autowired
    private ResgatePontuacaoRepository resgatePontuacaoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<ResgatePontuacaoDTO> listarTodos() {
        return resgatePontuacaoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ResgatePontuacaoDTO salvar(ResgatePontuacaoDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(dto.getIdPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if (pessoa.getPontuacao() < dto.getPontosResgatados()) {
            throw new RuntimeException("Pontuação insuficiente");
        }

        // Atualizar pontuação da pessoa
        pessoa.setPontuacao(pessoa.getPontuacao() - dto.getPontosResgatados());
        pessoaRepository.save(pessoa);

        // Salvar o resgate
        ResgatePontuacao resgate = new ResgatePontuacao();
        resgate.setPontosResgatados(dto.getPontosResgatados());
        resgate.setTipoResgate(dto.getTipoResgate());
        resgate.setData(LocalDateTime.now());
        resgate.setPessoa(pessoa);

        ResgatePontuacao salvo = resgatePontuacaoRepository.save(resgate);
        return toDTO(salvo);
    }

    private ResgatePontuacaoDTO toDTO(ResgatePontuacao r) {
        return new ResgatePontuacaoDTO(
                r.getId(),
                r.getPontosResgatados(),
                r.getTipoResgate(),
                r.getData(),
                r.getPessoa().getId());
    }
}
