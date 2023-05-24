package com.example.usedtransaction.service;

import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
  private final MemberRepository memberRepository;

  @Transactional
  public Member signUp(SignUpForm form) {
    return memberRepository.save(Member.from(form));
  }

  public boolean isEmailPresent(String email) {
    return memberRepository.findByEmail(email).isPresent();
  }



}
