package br.com.crescer.monitor.controller;

import lombok.RequiredArgsConstructor;
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

    @RequestMapping("/machineinfo/last15m")
    public ResponseEntity last15m(){
        
        //PEGA KEY PELO HEADER DO AGENTE LOGADO
        //TODO: MACHINEINFO LOGGED
        
        return ResponseEntity.ok(null);
    }
}
