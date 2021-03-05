package com.demo.core.member.repo;

import com.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepositoryByCore extends JpaRepository<Member, Long> {

    Optional<Member> findFirstByNameOrderByNameDesc(String upperName);
}
