package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.service.MachineInfoMockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alvaro
 */
@RestController
@RequestMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class DashboardController {

    @Autowired
    private final MachineInfoMockService machineInfoMockService;

    @RequestMapping("/machineinfo/{last15m")
    public ResponseEntity last15m(){
        
        //PEGA KEY PELO HEADER DO AGENTE LOGADO
        //TODO: MACHINEINFO LOGGED
        
        return ResponseEntity.ok(machineInfoMockService.last15m());
    }
}
