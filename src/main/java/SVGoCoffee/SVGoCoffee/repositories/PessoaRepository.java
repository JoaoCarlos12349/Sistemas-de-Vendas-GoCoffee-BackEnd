package SVGoCoffee.SVGoCoffee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SVGoCoffee.SVGoCoffee.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByCpf(String cpf);
}
