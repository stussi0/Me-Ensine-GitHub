package com.stussi.colecaogithub.controller;

import com.stussi.colecaogithub.model.TesteRequest;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
@RestController
public class PrincipalController {
    @CrossOrigin(origins = "*")
    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> index() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        JSONObject jsonAccountReturn = new JSONObject();
        jsonAccountReturn.put("msg", "Ok!");
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonAccountReturn.toString());
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping(value="/autenticado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testAutenticado() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        JSONObject jsonAccountReturn = new JSONObject();
        jsonAccountReturn.put("msg", "Ok!");
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonAccountReturn.toString());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value="/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Object> generalKenobi() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        JSONObject jsonAccountReturn = new JSONObject();
        jsonAccountReturn.put("msg", "Olá Mundo!");
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonAccountReturn.toString());
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping(value="/dia")
    public ResponseEntity<?> testJson() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        JSONObject jsonAccountReturn = new JSONObject();
        jsonAccountReturn.put("pais", "Brasil");
        jsonAccountReturn.put("numero", 55.0);
        jsonAccountReturn.put("valido", true);
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonAccountReturn.toString());
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(value="/dia")
    public ResponseEntity<?> testPostJson() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        JSONObject jsonAccountReturn = new JSONObject();
        jsonAccountReturn.put("estado", "Mato Grosso do Sul");
        jsonAccountReturn.put("numero", 67.0);
        jsonAccountReturn.put("valido", true);
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonAccountReturn.toString());
    }
    
    /**
     * Esta rota calcula o imc do usuário com o peso em kg e a altura em cm
     * @param jsonTestString as informações morfológicas do usuário
     * @return um JSON com as informações de peso altura e IMC
     * @throws Exception 
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value="/imc")
    public ResponseEntity<Object> testRequestJson(@Valid @RequestBody TesteRequest jsonTestString) throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders(); // Forma o cabeçalho da resposta
        httpHeaders.setContentType(MediaType.APPLICATION_JSON); // Define que a resposta será um json
        
        double peso_d = (double)jsonTestString.getPeso(); // pega a infromação de peso do request
        double altura_d = ((double)jsonTestString.getAltura())/100.0; // pega a informação de altura do request
        double imc_d = peso_d/Math.pow(altura_d, 2.0); // calcula o imc das informações do cabeçalho
        
        JSONObject jsonAccountReturn = new JSONObject(); // forma o json de resposta
        jsonAccountReturn.put("peso", peso_d); // acrescenta o peso à resposta
        jsonAccountReturn.put("altura", altura_d); // acrescenta à altura à resposta
        jsonAccountReturn.put("imc", imc_d); // acrescenta o imc à resposta
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonAccountReturn.toString()); // Retorna a resposta
    }
}
