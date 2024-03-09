package com.flab.collaboshoppingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member implements UserDetails {

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


    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override // 사용자의 패스워드 반환
    public String getPassword() {
        return pwHash;
    }

    @Override // 사용자의 id 반환(고유한 값)
    public String getUsername() {
        return email;
    }

    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        return true; // true : 만료 X
    }

    @Override // 계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true; // true : 잠금 X
    }

    @Override // 패스워드 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        return true; // true : 만료 X
    }

    @Override  // 계정 사용 가능 여부 반환
    public boolean isEnabled() {
        return true; // true : 사용 가능
    }
}
