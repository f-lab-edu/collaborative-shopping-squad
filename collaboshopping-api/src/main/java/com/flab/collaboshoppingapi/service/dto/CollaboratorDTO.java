package com.flab.collaboshoppingapi.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CollaboratorDTO {


    private long id;

    private long memberId;

    private int profit;


    public CollaboratorDTO(long id, long memberId, int profit) {
        this.id = id;
        this.memberId = memberId;
        this.profit = profit;
    }

    public CollaboratorDTO(long id) {
        this.id = id;
    }

    public CollaboratorDTO(long id, int profit) {
        this.id = id;
        this.profit = profit;
    }

    public CollaboratorDTO(int profit, long memberId) {
        this.profit = profit;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "CollaboratorDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", profit=" + profit +
                '}';
    }
}
