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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String uuid;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String pwHash;

    @Column
    private String role;

    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;





}
