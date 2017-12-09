package br.com.crescer.monitor.service;

import br.com.crescer.monitor.entity.MachineInfo;
import br.com.crescer.monitor.service.contract.MachineInfoServiceContract;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Alvaro
 */
@Service
public class MachineInfoMockService implements MachineInfoServiceContract{

    @Override
    public List<MachineInfo> last15m() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MachineInfo> last1h() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MachineInfo> last6h() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MachineInfo> last12h() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MachineInfo> last1d() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MachineInfo> last7d() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MachineInfo> last30d() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
