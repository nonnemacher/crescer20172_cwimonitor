package br.com.crescer.monitor.security;

import br.com.crescer.monitor.entity.Collaborator;
import br.com.crescer.monitor.service.CollaboratorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class MonitorUserDetailsService implements UserDetailsService {

    @Autowired
    CollaboratorService collaboratorService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Collaborator collaborator = collaboratorService.findByEmail(email);
        if (collaborator == null) {
            return null;
        }
        final List<GrantedAuthority> grants = new ArrayList<>();
        grants.add(() -> "ROLE_ADMIN");
        return new CustomUserDetails(collaborator, grants);
    }

}
