package br.com.cwi.monitor.agent.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alvaro
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private Long id;
    private double memoria;
    private double cPU;
    private double disco;
    private LocalDateTime hora;

    @Override
    public String toString() {
        return "Info{" + "id=" + id + ", memoria=" + memoria + ", cPU=" + cPU + ", disco=" + disco + ", hora=" + hora + '}';
    }
}
