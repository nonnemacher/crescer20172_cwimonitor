package br.com.cwi.monitor.agent.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Info {
    private Long id;
    private double memoria;
    private double cPU;
    private double disco;
    private LocalDateTime hora;
}
