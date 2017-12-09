package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.Machine;
import br.com.crescer.monitor.entity.Info;
import br.com.crescer.monitor.repository.InfoRepository;
import br.com.crescer.monitor.service.contract.InfoServiceContract;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Alvaro
 */
@Service
@RequiredArgsConstructor
public class InfoService implements InfoServiceContract{

    private final InfoRepository infoRepository;

    @Override
    public List<Info> last15m(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> last1h(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> last6h(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> last12h(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> last1d(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> last7d(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> last30d(Machine agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
