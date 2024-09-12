package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Rating implements Serializable {
    @Column(name = "generic_ticket_id",nullable = false)
    private Long genericTicket;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
