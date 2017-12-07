
package br.com.cwi.monitor.agent.persistence.repository;

import br.com.cwi.monitor.agent.entity.Info;
import java.util.List;

/**
 * @author Alvaro
 */
public interface InfoRepository extends Repository<Info>{
    void save(Info info);
    void delete(Info info);
    void delete(List<Info> infos);
    List<Info> retrieve(int n);
}
