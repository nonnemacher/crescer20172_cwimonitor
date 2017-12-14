package br.com.crescer.monitor.service;

import br.com.crescer.monitor.repository.MachineRegisterRepository;
import br.com.crescer.monitor.service.email.Email;
import br.com.crescer.monitor.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author alvaro.schmidt
 */
@Service
@RequiredArgsConstructor
public class AverageService {
    
    @Autowired
    private final EmailService emailService;
    
    @Autowired
    private final MachineRegisterRepository machineRegisterRepository;
    
    @Scheduled(fixedRate=30000, initialDelay = 5000)
    public void work() {
        System.out.println("Enviando o email.");
        
        Email email = Email.builder()
                           .to("alvaror.schmidt@gmail.com")
                           .from("cwimonitor.law@gmail.com")
                           .subject("Alerta!")
                           .message("Olá alvaro.").build();
        emailService.sendSimpleMessage(email);
    }
    
}
