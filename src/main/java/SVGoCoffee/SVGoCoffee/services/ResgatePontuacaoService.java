
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
                .map(ResgatePontuacaoDTO::new)
                .collect(Collectors.toList());
    }

    public ResgatePontuacaoDTO salvar(ResgatePontuacaoDTO resgatePontuacaoDTO) {
        Pessoa pessoa = pessoaRepository.findById(resgatePontuacaoDTO.getPessoa_id())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if (pessoa.getPontuacao() < resgatePontuacaoDTO.getPontosResgatados()) {
            throw new RuntimeException("Pontuação insuficiente");
        }

        // Atualizar pontuação da pessoa
        pessoa.setPontuacao(pessoa.getPontuacao() - resgatePontuacaoDTO.getPontosResgatados());
        pessoaRepository.save(pessoa);

        // Salvar o resgate
        ResgatePontuacao resgate = new ResgatePontuacao();
        resgate.setPontosResgatados(resgatePontuacaoDTO.getPontosResgatados());
        resgate.setTipoResgate(resgatePontuacaoDTO.getTipoResgate());
        resgate.setData(LocalDateTime.now());
        resgate.setPessoa(pessoa);

        ResgatePontuacao salvo = resgatePontuacaoRepository.save(resgate);
        return new ResgatePontuacaoDTO(salvo);
    }

}
