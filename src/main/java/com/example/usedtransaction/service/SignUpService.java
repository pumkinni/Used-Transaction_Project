package com.example.usedtransaction.service;

import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.exception.ErrorCode;
import com.example.usedtransaction.exception.MemberException;
import com.example.usedtransaction.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
  private final MemberRepository memberRepository;

  public Member signUp(SignUpForm form) {
    return memberRepository.save(Member.from(form));
  }

  public boolean isEmailPresent(String email) {
    return memberRepository.findByEmail(email).isPresent();
  }

  @Transactional
  public LocalDateTime changeMemberValidateEmail(Long memberId, String verificationCode) {
    Optional<Member> memberOptional = memberRepository.findById(memberId);

    if (memberOptional.isPresent()){
      Member member = memberOptional.get();

      member.setVerify(true);
      member.setVerificationCode(verificationCode);
      member.setVerificationExpiredAt(LocalDateTime.now().plusDays(1));

      return member.getVerificationExpiredAt();

    } else {
      throw new MemberException(ErrorCode.NOT_FOUND_USER);
    }
  }



}
