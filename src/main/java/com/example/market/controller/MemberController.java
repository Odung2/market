package com.example.market.controller;

import com.example.market.domain.entity.Member;
import com.example.market.dto.MemberRequest;
import com.example.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Long> signUp(MemberRequest memberRequest) {
        return ResponseEntity.ok(memberService.saveMember(memberRequest));
    }
}
