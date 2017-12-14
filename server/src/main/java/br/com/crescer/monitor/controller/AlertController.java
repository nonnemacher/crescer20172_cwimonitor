package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.AlertDto;
import br.com.crescer.monitor.entity.Alert;

import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.service.AlertService;
import static com.google.common.collect.Iterables.size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Willian
 */
@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @PostMapping
    public void save(@RequestBody AlertDto request) {

        alertService.save(request);
    }

    @GetMapping("/group")
    public Page<Alert> allAlert(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        return alertService.allAlert(new PageRequest(page, size, new Sort("id")));
    }

}
