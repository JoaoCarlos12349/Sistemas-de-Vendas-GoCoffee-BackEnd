package SVGoCoffee.SVGoCoffee.services;

import SVGoCoffee.SVGoCoffee.dto.ProdutoDTO;
import SVGoCoffee.SVGoCoffee.dto.ProdutoRequestDTO;
import SVGoCoffee.SVGoCoffee.entities.Produto;
import SVGoCoffee.SVGoCoffee.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private final Path uploadDir = Paths.get("img");

    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        return new ProdutoDTO(produto);
    }

    public ProdutoDTO salvar(ProdutoRequestDTO dto) throws IOException {
        Produto produto = new Produto();

        if (dto.getImagem() != null) {
            String nomeImagem = UUID.randomUUID().toString() + "_" + dto.getImagem().getOriginalFilename();
            Path caminhoImagem = uploadDir.resolve(nomeImagem);
            Files.copy(dto.getImagem().getInputStream(), caminhoImagem, StandardCopyOption.REPLACE_EXISTING);
            produto.setImagem(nomeImagem);
        }

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());
        Produto salvo = produtoRepository.save(produto);
        return new ProdutoDTO(salvo);
    }

    public ProdutoDTO update(Long id, ProdutoRequestDTO dto) throws IOException {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));

        if (dto.getImagem() != null) {
            String nomeImagem = UUID.randomUUID().toString() + "_" + dto.getImagem().getOriginalFilename();
            Path caminhoImagem = uploadDir.resolve(nomeImagem);
            Files.copy(dto.getImagem().getInputStream(), caminhoImagem, StandardCopyOption.REPLACE_EXISTING);
            produto.setImagem(nomeImagem);
        }

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());

        Produto atualizado = produtoRepository.save(produto);
        return new ProdutoDTO(atualizado);
    }

    public void delete(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }
    
}