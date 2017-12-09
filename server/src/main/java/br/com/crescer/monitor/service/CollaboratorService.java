/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.repository.CollaboratorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leonardo Bork
 */
@Service
public class CollaboratorService {

    @Autowired
    CollaboratorRepository collaboratorRepository;

    public Long save(Collaborator collaborator) {
        collaborator.setEmail(collaborator.getEmail().toLowerCase());
        
        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String pass = collaborator.getPass();
        collaborator.setPass(passwordEncoder.encode(pass));

        collaboratorRepository.save(collaborator);
        return collaborator.getId();
    }

    public void delete(Collaborator collaborator) {
        collaboratorRepository.delete(collaborator);
    }

    public Collaborator findOne(Long id) {
        return collaboratorRepository.findOne(id);
    }

    public List<Collaborator> findAll() {
        return (List<Collaborator>) collaboratorRepository.findAll();
    }

    public Collaborator findByEmail(String email) {
        return collaboratorRepository.findByEmailIgnoreCase(email);
    }

    public Collaborator loggedCollaborator() {
        return Optional
                .ofNullable(user())
                .map(User::getUsername)
                .map(this::findByEmail)
                .orElse(null);
    }

    private User user() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
    }
}
