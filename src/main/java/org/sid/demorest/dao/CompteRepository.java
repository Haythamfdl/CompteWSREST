package org.sid.demorest.dao;

import org.sid.demorest.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
}
