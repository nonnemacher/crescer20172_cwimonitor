package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alvaro
 */
@RestController
@RequestMapping(value = "/machine", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class MachineController {
    
    @Autowired
    private final MachineService machineService;

    @RequestMapping(value = "/generateKey", method = RequestMethod.GET)
    public ResponseEntity generateKey() {
        return ResponseEntity.status(HttpStatus.OK).body(machineService.generateKey());
    }
}   