package com.flab.collaboshoppingapi.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private Long id;

    private String code;

    private String name;

    private Long memberId;

    private String mainAddressYn;

    public AddressDTO(long id, String code, String name, String mainAddressYn) {
        this.id = id;
        this.name  = name;
        this.code = code;
        this.mainAddressYn = mainAddressYn;
    }

    public AddressDTO(long memberId) {
        this.memberId = memberId;
    }

    public AddressDTO(long id, long memberId) {
        this.id = id;
        this.memberId = memberId;
    }

    public AddressDTO(String code, String name, String mainAddressYn) {
        this.code = code;
        this.name = name;
        this.mainAddressYn = mainAddressYn;
    }

    public AddressDTO(String code, String name, long memberId, String mainAddressYn) {
        this.code = code;
        this.name = name;
        this.memberId = memberId;
        this.mainAddressYn = mainAddressYn;
    }
}
