package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "report_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReportType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "nvarchar(128)", nullable = false)
    private String name;

    @Column(name = "is_deleted",columnDefinition = "bit default 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "reportType")
    private List<ReportFraud> reportFraudList;
}
