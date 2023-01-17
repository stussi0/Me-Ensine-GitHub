package com.stussi.colecaogithub.controller;

import com.stussi.colecaogithub.config.JwtTokenUtil;
import com.stussi.colecaogithub.model.JwtRequest;
import com.stussi.colecaogithub.model.JwtResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * É a classe que realiza as autenticações do usuário através da rota ./auth
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
@RestController
@CrossOrigin
public class JwtAuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;
    
    /**
     * Define a rota para autenticação
     * obs: deve estar livre para acesso do usuário e liberada nos seguintes arquivos:
     * WebSecurityConfig - no método 'configure'
     * application.properties - na propriedade 'jwt.get.token.uri'
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getSenha());
        final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    /**
     * Este método autentica os usuários recebendo o nome e a senha
     * @param user é o nome do usuário
     * @param senha é a senha do usuário
     * @throws Exception caso o usuário esteja desabilitado ou com credenciais 
     * inválidas uma mensagem de erro será devolvida para ele
     */
    private void authenticate(String user, String senha) throws Exception {
        Objects.requireNonNull(user);
        Objects.requireNonNull(senha);
        
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user, senha));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
