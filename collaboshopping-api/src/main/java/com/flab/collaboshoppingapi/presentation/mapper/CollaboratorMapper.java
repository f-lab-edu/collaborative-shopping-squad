package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.CollaboratorApplyRequest;
import com.flab.collaboshoppingapi.service.dto.CollaboratorDTO;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorMapper {

    public CollaboratorDTO fromCollaboratorApplyRequest(CollaboratorApplyRequest request) {
        return new CollaboratorDTO(request.address(),request.name());
    }
}
