package com.flab.collaboshoppingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Trade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long collaboratorId;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column
    private Integer perPrice;

    @Column
    private Integer minPurchaseCount;

    @Column
    private String state;

    @Column
    private String originUrl;

    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;


  
}
