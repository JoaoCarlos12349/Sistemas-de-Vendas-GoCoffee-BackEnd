package SVGoCoffee.SVGoCoffee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SVGoCoffee.SVGoCoffee.entities.Usuario;
import SVGoCoffee.SVGoCoffee.repositories.UsuarioRepository;
import SVGoCoffee.SVGoCoffee.security.UsuarioDetails;

@Service
public class UsuarioDetailsService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: "+ login));
        return new UsuarioDetails(usuario);
    }

}
