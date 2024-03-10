package com.flab.collaboshoppingapi.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomUserInfoDto extends MemberDTO {
    private Long memberId;

    private String email;

    private String name;

    private String password;

    private RoleType role;

}