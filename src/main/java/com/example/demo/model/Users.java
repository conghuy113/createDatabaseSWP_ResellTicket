package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username" , columnDefinition = "nvarchar(100)",unique = true,nullable = false)
    private String username;

    @Column(name = "password" , length = 512 ,nullable = false)
    private String password;

    @Column(name = "firstname" , columnDefinition = "nvarchar(128)",nullable = false)
    private String firstname;

    @Column(name = "lastname" , columnDefinition = "nvarchar(128)",nullable = false)
    private String lastname;

    @Column(name = "email" , length = 128 ,nullable = false)
    private String email;

    @Column(name = "phone" , length = 12)
    private String phone;

    @Column(name = "avatar" ,columnDefinition = "varbinary(MAX)")
    @Lob
    private byte[] avatar;

    @Column(name = "is_enable",columnDefinition = "bit default 1")
    private Boolean isEnable;

    @Column(name = "role_code")
    @Enumerated(EnumType.STRING)
    private Role roleCode;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "customer_code", nullable = false)
    private String customerCode;

    @Column(name = "is_seller", columnDefinition = "bit default 0")
    private Boolean isSeller;

    @OneToMany(mappedBy = "user")
    private List<GenericTicket> genericTickets;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Rate> rateList;

    @OneToMany(mappedBy = "user")
    private List<ReportFraud> reportFraudList;
}
