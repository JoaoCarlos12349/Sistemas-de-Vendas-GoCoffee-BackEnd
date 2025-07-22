package SVGoCoffee.SVGoCoffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import SVGoCoffee.SVGoCoffee.dto.UsuarioDTO;
import SVGoCoffee.SVGoCoffee.entities.Pessoa;
import SVGoCoffee.SVGoCoffee.entities.TipoUsuario;
import SVGoCoffee.SVGoCoffee.entities.Usuario;

@SpringBootApplication
public class SistemaDeVendasGoCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeVendasGoCoffeeApplication.class, args);
	}

}
