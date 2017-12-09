/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.service.CollaboratorService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leonardo Bork
 */
@RestController
@RequestMapping(value = "/collaborator", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class CollaboratorController {

    @Autowired
    CollaboratorService collaboratorService;
    
    @PostMapping("/public")
    public ResponseEntity<Long> saveMachineRegister(@RequestBody @Valid Collaborator collaborator){
        return ResponseEntity.status(HttpStatus.CREATED).body(collaboratorService.save(collaborator));
    }
    
}
