package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.common.exception.CustomException;
import com.flab.collaboshoppingapi.common.exception.ErrorCode;
import com.flab.collaboshoppingapi.service.dto.CollaboratorDTO;
import com.flab.collaboshoppingapp.entity.Collaborator;
import com.flab.collaboshoppingapp.repository.CollaboratorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CollaboratorService {
    private final CollaboratorRepository collaboratorRepository;

    private Collaborator convertDtoToEntity(CollaboratorDTO collaboratorDTO) {
        Collaborator collaborator = new Collaborator();
        collaborator.setId(collaboratorDTO.getId());
        collaborator.setMemberId(collaboratorDTO.getMemberId());
        collaborator.setProfit(collaboratorDTO.getProfit());
        return collaborator;
    }

    private CollaboratorDTO convertEntityToDto(Collaborator collaborator) {
        CollaboratorDTO collaboratorDTO = new CollaboratorDTO();
        collaboratorDTO.setId(collaborator.getId());
        collaboratorDTO.setMemberId(collaborator.getMemberId());
        collaboratorDTO.setProfit(collaborator.getProfit());
        return collaboratorDTO;
    }

    public long insertCollaborator(CollaboratorDTO collaboratorDTO) {
        Collaborator collaborator = convertDtoToEntity(collaboratorDTO);
        return collaboratorRepository.save(collaborator).getId();
    }

    public long updateCollaborator(CollaboratorDTO collaboratorDTO) {
        Collaborator collaborator = collaboratorRepository.findById(collaboratorDTO.getId())
                .orElseThrow(() -> new CustomException("collaborator not found", ErrorCode.MEMBER_NOT_FOUND));
        collaborator.setMemberId(collaboratorDTO.getMemberId());
        collaborator.setProfit(collaboratorDTO.getProfit());
        return collaboratorRepository.save(collaborator).getId();
    }

    public long deleteCollaborator(CollaboratorDTO collaboratorDTO) {
        Collaborator collaborator = collaboratorRepository.findById(collaboratorDTO.getId())
                .orElseThrow(() -> new CustomException("collaborator not found",ErrorCode.MEMBER_NOT_FOUND));
        collaboratorRepository.delete(collaborator);
        return collaboratorDTO.getId();
    }

    public List<CollaboratorDTO> getCollaboratorList(CollaboratorDTO collaboratorDTO) {
        List<Collaborator> collaboratorList = collaboratorRepository.findAll();
        return collaboratorList.stream()
                .map(data -> convertEntityToDto(data))
                .collect(Collectors.toList());
    }

    public CollaboratorDTO getCollaborator(CollaboratorDTO collaboratorDTO) {
        Collaborator collaborator = collaboratorRepository.findById(collaboratorDTO.getId())
                .orElseThrow(() -> new CustomException("collaborator",ErrorCode.MEMBER_NOT_FOUND));
        return convertEntityToDto(collaborator);
    }
}
