package com.stussi.colecaogithub.model;

/**
 *
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
public class JwtResponse {
    
    private String nome;
    private String email;
    private String token;

    
    public JwtResponse(String token) {
        this.token = token;
    }
    
    public JwtResponse(String nome, String email, String token) {
        this.nome = nome;
        this.email = email;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

}
