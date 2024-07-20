package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.CollaboratorMapper;
import com.flab.collaboshoppingapi.presentation.request.*;
import com.flab.collaboshoppingapi.service.CollaboratorService;
import com.flab.collaboshoppingapi.service.dto.CollaboratorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.COLLABORATOR_V1)
public class CollaboratorController {


    private final CollaboratorService collaboratorSevice;
    private final CollaboratorMapper collaboratorMapper;

    @PostMapping("/insertCollaborator")
    public boolean insertCollaborator(@RequestBody @Validated CollaboratorInsertRequest request) throws Exception {
        collaboratorSevice.insertCollaborator(collaboratorMapper.fromCollaboratorInsertRequest(request));
        return true;
    }

    @PutMapping("/updateCollaborator")
    public long updateCollaborator(@RequestBody @Validated CollaboratorUpdateRequest request){
        return collaboratorSevice.updateCollaborator(collaboratorMapper.fromCollaboratorUpdateRequest(request));
    }

    @DeleteMapping("/deleteCollaborator")
    public long deleteCollaborator(@RequestBody @Validated CollaboratorDeleteRequest request){
        return collaboratorSevice.deleteCollaborator(collaboratorMapper.fromCollaboratorDeleteRequest(request));
    }

    @GetMapping("/getCollaboratorList")
    public List<CollaboratorDTO> getCollaboratorList(@RequestBody @Validated CollaboratorListSelectRequest request) {
        return collaboratorSevice.getCollaboratorList(collaboratorMapper.fromCollaboratorListSelectrequest(request));
    }

    @GetMapping("/getCollaborator")
    public CollaboratorDTO getCollaborator(@RequestBody @Validated CollaboratorSelectRequest request){
        return collaboratorSevice.getCollaborator(collaboratorMapper.fromCollaboratorSelectRequest(request));
    }
}
