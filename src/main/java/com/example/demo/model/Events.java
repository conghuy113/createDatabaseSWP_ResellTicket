package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Events {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "nvarchar(256)", nullable = false, unique = true)
    private String name;

    @Lob
    @Column(name = "image", columnDefinition = "varbinary(MAX)", nullable = false)
    private byte[] image;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "details", columnDefinition = "nvarchar(1024)", nullable = false)
    private String details;

    @Column(name = "is_deleted", columnDefinition = "bit default 0")
    private boolean isDeleted;

    @ManyToMany
    @JoinTable(
            name = "hashtags_event",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "hashtag_id")}
    )
    private List<Hashtags> hashtagsList;

    @OneToMany(mappedBy = "event")
    private List<GenericTicket> genericTicketList;
}
