package com.stussi.colecaogithub.model.agente;

/**
 * Esta classe representa um modelo do agente usuário, o qual pode criar questões,
 * vender questões, comprar questões, pesquisar questões, montar provas, imprimir
 * provas, comentar sobre as questões compradas, dar notas para as questões compradas,
 * apagar/modificar/deletar suas próprias questões. 
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
public class User {
    
    private String email;
    private String senha;

    public User() {
    }

    public User(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
