package com.encurteme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.encurteme.model.Links;
import com.encurteme.repository.LinksRepository;

@Service
public class LinksService {
    
    @Autowired
    private LinksRepository repository;


        public ResponseEntity<String> criarLink(String link){
            
            Optional<Links> verificarLink = repository.findByLink(link);

            if (verificarLink.isPresent()) {
                
                return ResponseEntity.status(HttpStatus.OK).body(verificarLink.get().getLinkEncurtado());

            }else{

                Links novoLink = new Links();

                String caracters = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                StringBuilder codigo = new StringBuilder(); 

                for(int i=0; i < 7; i++){

                    int posicao= (int) (Math.random() * caracters.length());

                    codigo.append(caracters.charAt(posicao));

                }

                novoLink.setLink(link);
                novoLink.setLinkEncurtado(codigo.toString());

                repository.save(novoLink);

                return ResponseEntity.status(HttpStatus.CREATED).body(codigo.toString());
            }

        }


    public ResponseEntity<String> redirecionarLink(String link){

        Optional<Links> verificarLink = repository.findByLinkEncurtado(link);

        if (verificarLink.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(verificarLink.get().getLink());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

}
