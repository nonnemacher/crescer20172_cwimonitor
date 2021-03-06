/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.service;

import br.com.crescer.monitor.dto.TagDto;
import br.com.crescer.monitor.entity.MachineTag;
import br.com.crescer.monitor.repository.MachineMonitoringGroupRepository;
import br.com.crescer.monitor.repository.MachineTagRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author willian.velhos
 */
@Service
public class MachineTagService {
    
    @Autowired
    private MachineTagRepository tagRepository;
    
    
    public List<TagDto> findByDescription(String descripition){
        
        List<MachineTag> tags= tagRepository.findByDescriptionContainingIgnoreCase(descripition);
        List<TagDto> tagsDto = new ArrayList<>();
        for(int x=0; x <tags.size(); x++){
            
            tagsDto.add(converter(tags.get(x)));
        }
        
        return tagsDto;
        
    }
    
    public TagDto converter(MachineTag machineTag) {
        return TagDto.builder()
                .text(machineTag.getDescription())
                .build();
    }
    
}