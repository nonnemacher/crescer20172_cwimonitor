/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.MachineInfoDto;
import br.com.crescer.monitor.service.MachineInfoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/machineinfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class MachineInfoController {

    @Autowired
    MachineInfoService machineInfoService;

    @PostMapping("/public")
    public ResponseEntity<Long> saveMachineInfo(@RequestBody List<MachineInfoDto> machineInfoDto) throws Exception {
        machineInfoService.saveList(machineInfoDto);
        return ResponseEntity.ok().body(null);
    }
}
