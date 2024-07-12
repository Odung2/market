package com.example.market.service;

import com.example.market.domain.entity.Member;
import com.example.market.domain.repository.MemberRepository;
import com.example.market.model.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long saveMember(MemberRequest memberRequest) {
        return memberRepository.save(
            Member.builder()
                .name(memberRequest.getName())
                .address(memberRequest.getAddress())
                .build()
        ).getId();
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

}
