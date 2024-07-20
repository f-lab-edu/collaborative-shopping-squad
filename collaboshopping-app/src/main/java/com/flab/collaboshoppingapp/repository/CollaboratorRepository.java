package com.flab.collaboshoppingapp.repository;

import com.flab.collaboshoppingapp.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator,Long> {

    Collaborator findByMemberId(long memberId);
}
