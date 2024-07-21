package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.*;
import com.flab.collaboshoppingapi.service.dto.CollaboratorDTO;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorMapper {

    public CollaboratorDTO fromCollaboratorInsertRequest(CollaboratorInsertRequest request) {
        return new CollaboratorDTO(request.profit(),request.memberId());
    }


    public CollaboratorDTO fromCollaboratorUpdateRequest(CollaboratorUpdateRequest request) {
        return new CollaboratorDTO(request.id(),request.profit());
    }

    public CollaboratorDTO fromCollaboratorDeleteRequest(CollaboratorDeleteRequest request) {
        return new CollaboratorDTO(request.id());
    }

    public CollaboratorDTO fromCollaboratorListSelectrequest(CollaboratorListSelectRequest request) {
        return new CollaboratorDTO();
    }

    public CollaboratorDTO fromCollaboratorSelectRequest(CollaboratorSelectRequest request) {
        return new CollaboratorDTO(request.id());
    }
}
