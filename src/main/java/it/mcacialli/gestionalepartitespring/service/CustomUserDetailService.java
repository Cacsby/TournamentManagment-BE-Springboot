package it.mcacialli.gestionalepartitespring.service;

import it.mcacialli.gestionalepartitespring.model.Ruolo;
import it.mcacialli.gestionalepartitespring.model.Utente;
import it.mcacialli.gestionalepartitespring.repository.RuoloRepository;
import it.mcacialli.gestionalepartitespring.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    RuoloRepository ruoloRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Utente utente = utenteRepository.findByNomeUtente(username);

        if(utente == null)
            throw new UsernameNotFoundException("Utente non trovato");

        List<Ruolo> listaRuoli = ruoloRepository.findAll();
        // List<SimpleGrantedAuthority> authoritiess = listaRuoli.stream().map(ruolo -> new SimpleGrantedAuthority(ruolo.getNomeRuolo())).toList();
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(utente.getIdRuolo().getNomeRuolo()));

        return new User(utente.getNomeUtente(), utente.getPassword(), authorities);
        // return new User("foo", "foo", new ArrayList<>());

    }

}
