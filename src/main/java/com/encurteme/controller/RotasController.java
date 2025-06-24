package com.encurteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.encurteme.service.LinksService;


@Controller
public class RotasController {
    
    @Autowired
    private LinksService service;

    @GetMapping("/")
    public String paginaInicial() {
        return "index";
    }
    

    @GetMapping("/link/{codigo}")
    public ResponseEntity<String> redirecionar(@PathVariable String codigo) {
        
        ResponseEntity<String> resposta = service.redirecionarLink(codigo);

        if (resposta.getStatusCode().is2xxSuccessful()) {
            
            String url = resposta.getBody();

            return ResponseEntity.status(HttpStatus.FOUND)
                             .header("Location", url)
                             .build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Link não encontrado");
        }

    }

}
