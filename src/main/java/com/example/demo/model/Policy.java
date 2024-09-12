package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "policy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Policy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "nvarchar(MAX)")
    private String content;

    private Integer fee;

    @Column(name = "is_deleted", columnDefinition = "bit default 0")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "type_policy_id")
    private TypePolicy typePolicy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "policy")
    private List<GenericTicket> genericTicketList;
}
