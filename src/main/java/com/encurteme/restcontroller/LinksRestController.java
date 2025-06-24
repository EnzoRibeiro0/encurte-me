package com.encurteme.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encurteme.service.LinksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class LinksRestController {
    
    @Autowired
    private LinksService service;

    @Operation(description = "Gerar o link encurtado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "O link já existe na base de dados, então ocorreu apenas o retorno do link encurtado"),
        @ApiResponse(responseCode = "201", description = "Um novo link encurtado foi gerado")
    })
    @GetMapping("/link")
    public ResponseEntity<String> gerarCodigo(@RequestParam String link) {
        
        ResponseEntity<String> resposta = service.criarLink(link); 

        String codigo = resposta.getBody();
        String url = "localhost:8080/link/" + codigo;
        
        return ResponseEntity.status(resposta.getStatusCode()).body(url);
    }
    

}
