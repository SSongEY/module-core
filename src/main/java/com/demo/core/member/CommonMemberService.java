package com.demo.core.member;

import com.demo.core.member.repo.MemberRepositoryByCore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonMemberService {

    private final MemberRepositoryByCore memberRepositoryByCore;

    public String toUpperCaseAndCheckDuplicateName(String name) {

        String upperName = name.toUpperCase();
        memberRepositoryByCore.findFirstByNameOrderByNameDesc(upperName).ifPresent(member -> {
            throw new IllegalArgumentException("Already in use");
        });
        return upperName;
    }

}
