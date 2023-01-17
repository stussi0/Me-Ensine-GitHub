package com.stussi.colecaogithub.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Alberto Schwind Pedroso Stussi da Silva Pereira
 */
@RestController
@RequestMapping("/sub")
public class SubpageController {
    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "Estamos aqui!";
    }

    @GetMapping(value="/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String testeAPISub() {
        return "Sub discreta!";
    }
}
