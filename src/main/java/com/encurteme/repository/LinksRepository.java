package com.encurteme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encurteme.model.Links;

public interface LinksRepository extends JpaRepository<Links, String> {
    
    Optional<Links> findByLink(String link);

    Optional<Links> findByLinkEncurtado(String linkEncurtado);

}
