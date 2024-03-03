package com.flab.collaboshoppingapp.repository;

import com.flab.collaboshoppingapp.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {


    boolean existsByEmail(String email);
}
