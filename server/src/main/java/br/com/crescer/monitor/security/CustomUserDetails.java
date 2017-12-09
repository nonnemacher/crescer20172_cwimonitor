/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitor.security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.crescer.monitor.entity.Collaborator;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Leonardo Bork
 */
public class CustomUserDetails extends User {

    public CustomUserDetails(Collaborator collaborator, Collection<? extends GrantedAuthority> authorities
    ) {
        super(collaborator.getEmail(), collaborator.getPass(), authorities);
    }

}

