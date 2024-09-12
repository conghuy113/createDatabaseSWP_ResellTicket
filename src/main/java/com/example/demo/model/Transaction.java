package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "[transaction]")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trans_date", nullable = false)
    private Date transDate;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "is_done", nullable = false,columnDefinition = "bit default 0")
    private Boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
