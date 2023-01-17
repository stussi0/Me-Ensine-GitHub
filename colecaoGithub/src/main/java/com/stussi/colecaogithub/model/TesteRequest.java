package com.stussi.colecaogithub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 *
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
public class TesteRequest {
    
    @NotNull(message = "falta a altura!")
    @NotEmpty(message = "altura vazia!")
    private int altura;
    
    @NotNull(message = "falta a peso!")
    @NotEmpty(message = "peso vazia!")
    private int peso;
    
    public TesteRequest() {
        
    }
    
    public TesteRequest(int peso, int altura){
        this.setPeso(peso);
        this.setAltura(altura);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
