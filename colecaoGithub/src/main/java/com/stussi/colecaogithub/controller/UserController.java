package com.stussi.colecaogithub.controller;

import com.stussi.colecaogithub.model.agente.User;
import com.stussi.colecaogithub.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este controler é responsável pelas rotas de controle das contas
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
@RestController // No framework spring todo controler tem que ser marcado como controller
@RequestMapping("/users") // Estou definindo que o caminho desta rota, logo o endereço será "localhost:8080/contas/"
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Object> addUser(@RequestBody User jsonUserString) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        if(userService.emailExiste(jsonUserString.getEmail())){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).headers(httpHeaders).body(
                    new JSONObject()
                            .put("erro", "Já existe um usuário com o email informado.")
                            .toString());
        }
        
        String Senha = jsonUserString.getSenha();
        String encryptedSenha = userService.encryptPassword(Senha);
        jsonUserString.setSenha(encryptedSenha);
        
        userService.add(jsonUserString);
        
        JSONObject jsonUserReturn = new JSONObject(); // forma o json de resposta
        jsonUserReturn.put("email", jsonUserString.getEmail()); // acrescenta email à resposta
        jsonUserReturn.put("senha_cryp", encryptedSenha); // acrescenta à senha à resposta
        
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(jsonUserReturn.toString());
    }
}
