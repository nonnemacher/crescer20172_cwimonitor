package br.com.crescer.monitor.service.contract;

import br.com.crescer.monitor.entity.Machine;
import br.com.crescer.monitor.entity.Info;
import java.util.List;

/**
 * @author Alvaro
 */
public interface InfoServiceContract {

    List<Info> last15m(Machine agent);

    List<Info> last1h(Machine agent);

    List<Info> last6h(Machine agent);

    List<Info> last12h(Machine agent);

    List<Info> last1d(Machine agent);
    
    List<Info> last7d(Machine agent);
    
    List<Info> last30d(Machine agent);
    
}
