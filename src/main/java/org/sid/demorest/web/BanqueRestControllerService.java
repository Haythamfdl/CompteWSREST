package org.sid.demorest.web;

import org.sid.demorest.dao.CompteRepository;
import org.sid.demorest.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BanqueRestControllerService {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes")
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte getComptes(@PathVariable Long code){
        return compteRepository.findById(code).get();
    }

    @PostMapping(path = "/comptes")
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping(path = "/comptes/{code}")
    public Compte update(@PathVariable Long code, @RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{code}")
    public void delete(@PathVariable Long code){
        compteRepository.deleteById(code);
    }
}
