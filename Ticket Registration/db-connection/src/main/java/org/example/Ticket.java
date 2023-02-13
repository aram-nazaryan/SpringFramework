package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Ticket {
    private /*volatile*/ String id;
    private boolean isActive;
    private String registeredDate;

    public Ticket() {
        this.id = TicketIdGenerator.generateId();
        this.isActive = true;
        this.registeredDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
