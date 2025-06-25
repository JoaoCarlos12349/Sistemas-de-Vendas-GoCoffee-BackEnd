package SVGoCoffee.SVGoCoffee.dto;

import SVGoCoffee.SVGoCoffee.entities.TipoUsuario;
import SVGoCoffee.SVGoCoffee.entities.Usuario;

public class UsuarioDTO {
    private Long id;
    private String login;
    private String tipoUsuario;
    private String senha;
    private Long pessoa_id;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.tipoUsuario = usuario.getTipoUsuario().name();
        this.pessoa_id = usuario.getPessoa().getId();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Long getPessoa_id() {
        return pessoa_id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

}
