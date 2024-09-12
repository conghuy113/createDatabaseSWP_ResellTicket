package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Ticket {

    @Id
    @Column(name = "ticket_serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketSerial;

    @Column(name = "expired_date_time", nullable = false)
    private Date expiredDateTime;

    @Lob
    @Column(name = "image", columnDefinition = "varbinary(MAX)")
    private byte[] image;

    @Column(name = "is_checked", columnDefinition = "bit default 0")
    private boolean isChecked;

    @Column(name = "is_bought", columnDefinition = "bit default 0")
    private boolean isBought;

    @Column(name = "verify_process", columnDefinition = "varchar(32) default 'WAITING'")
    @Enumerated(value = EnumType.STRING)
    private VerifyProcess verifyProcess= VerifyProcess.WAITING;

    @ManyToOne
    @JoinColumn(name = "generic_ticket_id")
    private GenericTicket genericTicket;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}
