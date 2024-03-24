package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.CollaboratorMapper;
import com.flab.collaboshoppingapi.presentation.request.CollaboratorApplyRequest;
import com.flab.collaboshoppingapi.presentation.request.MemberJoinRequest;
import com.flab.collaboshoppingapi.service.CollaboratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.COLLABORATOR_V1)
public class CollaboratorController {


    private final CollaboratorService collaboratorSevice;
    private final CollaboratorMapper collaboratorMapper;

    @PostMapping("/apply")
    public String apply(@RequestBody @Validated CollaboratorApplyRequest request) throws Exception {
        log.info("apply");
        log.info(request.toString());
        collaboratorSevice.apply(collaboratorMapper.fromCollaboratorApplyRequest(request));
        return "complete";
    }







}
