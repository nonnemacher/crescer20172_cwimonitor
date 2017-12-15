package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.service.MachineRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.crescer.monitor.dto.MachineRegisterNameDto;


/**
 * @author Alvaro
 */
@RestController
@RequestMapping(value = "/machineregister", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class MachineRegisterController {

    @Autowired
    MachineRegisterService machineRegisterService;

    @PostMapping
    public ResponseEntity<Long> saveMachineRegister(@RequestBody MachineRegisterDto machineRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(machineRegisterService.save(machineRegisterDto));
    }

    @GetMapping
    public Page<MachineRegister> getMachines(            
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {

        return machineRegisterService.findByCollaborator(new PageRequest(page, size, new Sort("id")));
    }

    @GetMapping("/all")
    public ResponseEntity allMachine() {

        return ok(machineRegisterService.allMachine());
    }

    @PutMapping("/machinename")
    public ResponseEntity updateMachineName(@RequestBody MachineRegisterNameDto machineRegisterNameDto) {
        MachineRegister machineRegister = machineRegisterService.findByGeneratedKey(machineRegisterNameDto.getGeneratedKey());
        if (machineRegister == null) {
            return ResponseEntity.badRequest().build();
        }
        machineRegister.setMachineName(machineRegisterNameDto.getName());

        machineRegisterService.saveMachineRegister(machineRegister);

        return ResponseEntity.ok(machineRegister);
    }

    @GetMapping("/noGroup/{id}")
    public Page<MachineRegister> getMachinesWithoutGroup(@PathVariable Long id,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        return machineRegisterService.findMachineWithoutGroup(id, new PageRequest(page, size, new Sort("id")));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        machineRegisterService.delete(id);
    }

    @GetMapping("/group/{id}")
    public Page<MachineRegister> getMachinesByGroup(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        return machineRegisterService.findByGroups(id, new PageRequest(page, size, new Sort("id")));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {

        return ok(machineRegisterService.findById(id));
    }
}