package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.entity.MachineMonitoringGroup;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.entity.MachineTag;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import br.com.crescer.monitor.repository.MachineRegisterRepository;
import br.com.crescer.monitor.repository.MachineTagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Alvaro
 */
@Service
@RequiredArgsConstructor
public class MachineRegisterService {

    @Autowired
    private final MachineRegisterRepository machineRegisterRepository;

    @Autowired
    private final MachineTagRepository machineTagRepository;

    @Autowired
    private final CollaboratorService collaboratorService;

    @Autowired
    private MachineMonitoringGroupRepository groupRepository;

    public MachineRegister findById(Long id) {
        return machineRegisterRepository.findOne(id);
    }

    public Page<MachineRegister> findByCollaborator(Pageable pgbl) {

        return machineRegisterRepository.findByCollaborator(collaboratorService.loggedCollaborator(), pgbl);
    }

    public List<MachineRegister> allMachine() {

        return (List<MachineRegister>) machineRegisterRepository.findAll();
    }

    public void saveMachineRegister(MachineRegister machineRegister) {
        machineRegisterRepository.save(machineRegister);
    }  

    public MachineRegister findByGeneratedKey(String generatedKey) {
        return machineRegisterRepository.findByGeneratedKey(generatedKey);
    }
      
    public Page<MachineRegister> findByGroups(Long id, Pageable pgbl) {

        MachineMonitoringGroup group = groupRepository.findOne(id);

        return machineRegisterRepository.findByGroups(group, pgbl);
    }

    public Page<MachineRegister> allAgents(Pageable pgbl) {

        return machineRegisterRepository.findAll(pgbl);
    }

    public Long save(MachineRegisterDto machineRegisterDto) {

        //TODO: ADICIONAR COLLABORATOR COMO COLLABORATOR LOGADO
        List<MachineTag> machineTags = new ArrayList<>();

        for (String c : machineRegisterDto.getTags()) {
            MachineTag findByDescription = machineTagRepository.findByDescription(c);
            if (findByDescription == null) {
                MachineTag tagSave = MachineTag.builder().description(c).build();
                machineTagRepository.save(tagSave);
                machineTags.add(tagSave);
            } else {
                machineTags.add(findByDescription);
            }
        }

        MachineRegister machineRegister = MachineRegister.builder()
                .machineNickname(machineRegisterDto.getMachineNickname())
                .collaborator(collaboratorService.loggedCollaborator())
                .tags(machineTags)
                .generatedKey(this.generateKey())
                .build();

        machineRegisterRepository.save(machineRegister);
        return machineRegister.getId();
    }

    public Page<MachineRegister> findMachineWithoutGroup(Long id, Pageable pgbl) {

        MachineMonitoringGroup group = groupRepository.findOne(id);

        List<Long> ids = machineRegisterRepository.findByGroups(group).stream().map(MachineRegister::getId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(ids)) {
            return machineRegisterRepository.findAll(pgbl);
        }
        return machineRegisterRepository.findByIdNotIn(ids, pgbl);
    }

    public String generateKey() {
        String key = UUID.randomUUID().toString();
        return key;
    }

    public void delete(Long id) {
        machineRegisterRepository.delete(id);
    }
}
