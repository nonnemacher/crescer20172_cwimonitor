/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.repository.CollaboratorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leonardo Bork
 */
@Service
public class CollaboratorService {

    @Autowired
    CollaboratorRepository collaboratorRepository;

    public void save(Collaborator collaborator) {
        collaborator.setEmail(collaborator.getEmail().toLowerCase());
        collaboratorRepository.save(collaborator);
    }
    
    public void delete(Collaborator collaborator){
        collaboratorRepository.delete(collaborator);
    }
    
    public Collaborator findOne(Long id){
        return collaboratorRepository.findOne(id);
    }
    
    public List<Collaborator> findAll(){
        return (List<Collaborator>) collaboratorRepository.findAll();
    }
    
    public Collaborator findByEmail(String email){
        return collaboratorRepository.findByEmailIgnoreCase(email);
    }    
}
