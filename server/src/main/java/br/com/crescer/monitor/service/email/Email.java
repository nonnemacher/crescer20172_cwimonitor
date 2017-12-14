package br.com.crescer.monitor.service.email;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;

/**
 * @author Alvaro
 */
@Data
@Builder
@AllArgsConstructor
public class Email {

    private String from;

    private String to;

    private String subject;

    private String message;

    public Email() {}
}
