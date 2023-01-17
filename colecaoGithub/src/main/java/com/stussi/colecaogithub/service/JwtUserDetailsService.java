package com.stussi.colecaogithub.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Esta clase é responsável por fornecer os serviços de acesso as informaçõesrio 
 * utilizando JWT, ou seja, informando os dados do usuário armazenados no banco 
 * de dados para a API de validação, autorização e autenticação do usuário.
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userService.emailExiste(username)){
            com.stussi.colecaogithub.model.agente.User usuario = userService.getUser(username);
            return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuário com o nome: " + username+" não encontrado!");
        }
    }
}