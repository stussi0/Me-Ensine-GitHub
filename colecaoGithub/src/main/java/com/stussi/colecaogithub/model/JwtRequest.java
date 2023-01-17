package com.stussi.colecaogithub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 * Esta classe representa um request de autenticação
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
public class JwtRequest {
    @NotNull(message = "Campo email ausente!")
    @NotEmpty(message = "Campo email vazio!")
    private String email;
    
    @NotNull(message = "Campo senha ausente!")
    @NotEmpty(message = "Campo senha vazio!")
    private String senha;

    public JwtRequest() {

    }
    
    public JwtRequest(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
