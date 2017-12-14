/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.monitor.dto.CollaboratorDto;

/**
 *
 * @author Leonardo Bork
 */
@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

    @Autowired
    CollaboratorService collaboratorService;
    
    @PostMapping("/public")
    public ResponseEntity saveMachineRegister(@RequestBody CollaboratorDto collaborator){       
        return ok(collaboratorService.save(collaborator));
    }
    
}