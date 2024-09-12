package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "generic_tickets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GenericTicket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_name", columnDefinition = "nvarchar(128)", nullable = false)
    private String ticketName;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "sale_percent")
    private Double salePercent;

    @Column(name = "area", columnDefinition = "nvarchar(128)")
    private String area;

    @Column(name = "description", columnDefinition = "nvarchar(1024)")
    private String description;

    @Column(name = "link_event", columnDefinition = "nvarchar(512)")
    private String linkEvent;

    @Column(name = "is_paper")
    private boolean isPaper;

    @OneToMany(mappedBy = "genericTicket")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events event;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "genericTicket")
    private List<Rate> rateList;
}
