package br.com.crescer.monitor.controller;

import br.com.crescer.monitor.dto.InfoResponseModel;
import br.com.crescer.monitor.entity.Machine;
import br.com.crescer.monitor.service.AgentService;
import br.com.crescer.monitor.service.InfoMockService;
import br.com.crescer.monitor.service.InfoService;
import br.com.crescer.monitor.service.contract.InfoServiceContract;
import br.com.crescer.social.entity.Info;
import br.com.crescer.social.component.UsuarioLogado;
import br.com.crescer.social.entity.Relacao;
import br.com.crescer.social.entity.Usuario;
import br.com.crescer.social.repository.InfoRepository;
import br.com.crescer.social.service.RelacaoService;
import br.com.crescer.social.service.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alvaro
 */
@RestController
@RequestMapping(value = "/dash", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class DashController {

    //@Autowired
    private final InfoServiceContract infoService = new InfoMockService();
    
    private final AgentService agentService;

    @RequestMapping("/agent/{key}/last15m")
    public ResponseEntity last15m(@RequestParam("key") Long agentKey) {
        Machine agent = agentService.findOne(agentKey);
        List<InfoResponseModel> infos = infoService.last15m(agent);
        
        return ResponseEntity.ok(infos);
    }
}
