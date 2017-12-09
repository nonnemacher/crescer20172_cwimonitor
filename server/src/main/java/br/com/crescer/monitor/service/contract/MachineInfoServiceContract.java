package br.com.crescer.monitor.service.contract;

import br.com.crescer.monitor.entity.MachineInfo;
import java.util.List;
import javax.sound.sampled.Mixer.Info;

/**
 * @author Alvaro
 */
public interface MachineInfoServiceContract {

    List<MachineInfo> last15m();

    List<MachineInfo> last1h();

    List<MachineInfo> last6h();

    List<MachineInfo> last12h();

    List<MachineInfo> last1d();

    List<MachineInfo> last7d();

    List<MachineInfo> last30d();

}
