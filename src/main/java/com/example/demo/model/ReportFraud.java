package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "report_fraud")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReportFraud {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", columnDefinition = "nvarchar(1024)", nullable = false)
    private String content;

    @Column(name = "proof", columnDefinition = "varbinary(MAX)", nullable = false)
    @Lob
    private byte[] proof;

    @Column(name = "report_process", columnDefinition = "varchar(32) default 'WAITING'", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ReportProcess reportProcess;

    @ManyToOne
    @JoinColumn(name = "report_typeId")
    private ReportType reportType;

    @Column(name = "staff_id",nullable = false)
    private Long staffId;

    @Column(name = "reported_user_id", nullable = false)
    private Long reportedUserId;

    @Column(name = "generic_ticket_id",nullable = false)
    private Long genericTicket;
}
