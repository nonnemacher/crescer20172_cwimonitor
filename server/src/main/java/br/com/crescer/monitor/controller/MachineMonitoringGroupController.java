package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.MachineMonitoringGroupDto;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.service.MachineMonitoringGroupService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.badRequest;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Willian
 */
@RestController
@RequestMapping("/group")
public class MachineMonitoringGroupController {

    @Autowired
    private MachineMonitoringGroupService groupService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody MachineMonitoringGroupDto request) throws IOException {

        if (request == null) {
            return badRequest().body("Parâmetro null.");
        }

        return ok(groupService.save(request));

    }
    
    @GetMapping("/pesquisar/{request}")
    public Page<MachineMonitoringGroup> findByDescription(
            @PathVariable String request,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size){
        
        return groupService.findByDescription(request, new PageRequest(page, size, new Sort("id")));
    }

    @PutMapping("/removeMachineRegister")
    public void removeMachineRegister(@RequestParam Long group, @RequestParam Long machine) throws Exception {

        groupService.removeMachineRegister(group, machine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        groupService.delete(id);

    }

    @GetMapping
    public Page<MachineMonitoringGroup> allGroup(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {

        return groupService.allGroup(new PageRequest(page, size, new Sort("id")));
    }

    @PostMapping("/add")
    public void addMachineRegister(@RequestParam Long group, @RequestParam Long machine) throws Exception {

        groupService.addMachineRegister(group, machine);
    }

    @GetMapping("/all")
    public ResponseEntity allGroup(){

        return ok(groupService.allGroup());
    }

    @PostMapping("/file")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {

        File foto = new File("C:\\DEV\\willian.velhos\\tcc\\crescer20172_cwimonitor\\front\\img\\" + file.getOriginalFilename());

        foto.createNewFile();
        FileOutputStream fos = new FileOutputStream(foto);
        fos.write(file.getBytes());
        fos.close();

    }

}
