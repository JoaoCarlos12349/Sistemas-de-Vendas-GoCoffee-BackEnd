package SVGoCoffee.SVGoCoffee.dto;

import SVGoCoffee.SVGoCoffee.entities.Cliente;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Integer pontos;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.pontos = cliente.getPontos();
    }

    // Getters e Setters
}
