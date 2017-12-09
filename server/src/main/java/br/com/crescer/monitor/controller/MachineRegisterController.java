package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.service.MachineRegisterService;
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
 * @author Alvaro
 */
@RestController
@RequestMapping(value = "/machineregister", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class MachineRegisterController {

    @Autowired
    MachineRegisterService machineRegisterService;
    
    @PostMapping("/public")
    public ResponseEntity<Long> saveMachineRegister(@RequestBody MachineRegisterDto machineRegisterDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(machineRegisterService.save(machineRegisterDto));
    }
    
}
