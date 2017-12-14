/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.service.MachineTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author willian.velhos
 */
@RestController
@RequestMapping("/tag")
public class MachineTagController {
    
     @Autowired
    private MachineTagService tagService;
    
    @GetMapping("/{description}")
    public ResponseEntity findById(@PathVariable String description,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        return ok( tagService.findByDescription(description,new PageRequest(page, size)));
    }
}