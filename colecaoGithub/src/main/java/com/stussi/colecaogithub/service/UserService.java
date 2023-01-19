package com.stussi.colecaogithub.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
@Service
public class UserService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
    
    private ArrayList<com.stussi.colecaogithub.model.agente.User> users;
    
    /**
     * Este método verifica se o e-mail informado existe na lista de usuários
     * @param email uma string contendo o endereço completo do email que será pesquisado
     * @return true caso o email exista na lista e false caso contrário
     */
    public boolean emailExiste(String email) {
        if (users != null) {
            for (com.stussi.colecaogithub.model.agente.User user : users) {
                if (user.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Adiciona um usuário à lista de usuários
     * @param user o novo usuário do sistema
     */
    public void add(com.stussi.colecaogithub.model.agente.User user) {
        if (users == null){
            users = new ArrayList<>();
            com.stussi.colecaogithub.model.agente.User usuario = new com.stussi.colecaogithub.model.agente.User();
            usuario.setEmail("luis@unigran.br");
            usuario.setSenha("$2a$10$uxzjpWQidv5P31B76d37eeaLmP3fwIqH.A0U83l1YVzj2w9PbWuc6");
            users.add(usuario);
        }
        users.add(user);
        System.out.println("Quantidade de users: "+users.size());
    }
    
    /**
     * Este método retorna um usuário especificado oelo email
     * @param email uma string contendo o endereço completo do email que será pesquisado
     * @return true caso o email exista na lista e false caso contrário
     */
    public com.stussi.colecaogithub.model.agente.User getUser(String email) {
        if (users == null){
            users = new ArrayList<>();
            com.stussi.colecaogithub.model.agente.User usuario = new com.stussi.colecaogithub.model.agente.User();
            usuario.setEmail("luis@unigran.br");
            usuario.setSenha("$2a$10$uxzjpWQidv5P31B76d37eeaLmP3fwIqH.A0U83l1YVzj2w9PbWuc6");
            users.add(usuario);
        }
        if (users != null) {
            for (com.stussi.colecaogithub.model.agente.User user : users) {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }
        }
        return null;
    }
}
