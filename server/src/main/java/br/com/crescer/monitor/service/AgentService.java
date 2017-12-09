package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.Machine;
import br.com.crescer.monitor.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Alvaro
 */
@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentRepository agentRepository;
    
    public Machine findOne(Long key) {
        return agentRepository.findOne(key);
    }   
}
