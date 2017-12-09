package br.com.crescer.monitor.service;

import br.com.crescer.monitor.repository.MachineInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alvaro
 */
@Service
@RequiredArgsConstructor
public class MachineInfoService {

    @Autowired
    MachineInfoRepository machineInfoRepository;
    
   
}
