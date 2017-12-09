package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.Machine;
import br.com.crescer.monitor.repository.MachineRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alvaro
 */
@Service
@RequiredArgsConstructor
public class MachineService {
    
    @Autowired
    private final MachineRepository machineRepository;
    
    /**
     * Este método gera uma key, cria uma Machine nova, salva no banco e retorna ela.
     * @return 
     */
    public String generateKey() {
        String key = UUID.randomUUID().toString();
        Machine machine = Machine.builder().generatedKey(key).build();
        machineRepository.save(machine);
        return key;
    }
    
}
