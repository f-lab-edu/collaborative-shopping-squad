package com.flab.collaboshoppingapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    private String email;

    private String name;

    private String phone;

    private String pw;

    private String role;

    @Override
    public String toString(){
        return email+" / "+name+" / "+phone+" / "+pw+" / "+role;
    }
}
