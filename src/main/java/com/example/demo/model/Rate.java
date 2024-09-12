package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rate {
    @EmbeddedId
    private Rating rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("genericTicket")
    private GenericTicket genericTicket;

    @Column(name = "comment", columnDefinition = "nvarchar(1024)")
    private String comment;

    @Column(name = "stars", nullable = false)
    private Short stars;
}
