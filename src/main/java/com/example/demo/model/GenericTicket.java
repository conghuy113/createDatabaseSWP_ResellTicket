package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "generic_ticket")
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "genericTicket")
    private List<Rate> rateList;
}