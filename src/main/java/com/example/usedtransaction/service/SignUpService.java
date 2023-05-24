package com.example.usedtransaction.service;

import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
  private final MemberRepository memberRepository;

  public Member signUp(SignUpForm form) {
    return memberRepository.save(Member.from(form));
  }

}
