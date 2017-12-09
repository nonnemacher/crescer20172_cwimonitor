package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.MachineRegisterDto;
import br.com.crescer.monitor.entity.MachineRegister;
import br.com.crescer.monitor.entity.MachineTag;
import br.com.crescer.monitor.repository.MachineRegisterRepository;
import br.com.crescer.monitor.repository.MachineTagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //Adiciona um registro sem nenhum grupo, 

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

        MachineRegister machineRegister = MachineRegister.builder().machineName(machineRegisterDto.getMachineName()).
                machineRoomLocation(machineRegisterDto.getMachineRoomLocation()).
                    tags(machineTags).
                        generatedKey(this.generateKey()).
                            build();

        machineRegisterRepository.save(machineRegister);
        return machineRegister.getId();
    }

    public String generateKey() {
        String key = UUID.randomUUID().toString();
        return key;
    }
    
    public void delete(Long id){
        machineRegisterRepository.delete(id);
    }
}
