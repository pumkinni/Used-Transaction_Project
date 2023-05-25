package com.example.usedtransaction.service;

import static com.example.usedtransaction.exception.ErrorCode.ALREADY_VERIFY;
import static com.example.usedtransaction.exception.ErrorCode.EXPIRED_CODE;
import static com.example.usedtransaction.exception.ErrorCode.NOT_FOUND_USER;
import static com.example.usedtransaction.exception.ErrorCode.WRONG_VERIFICATION;

import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.exception.CustomException;
import com.example.usedtransaction.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
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
  public void verifyEmail(String email, String code) {
    Member member = memberRepository.findByEmail(email)
        .orElseThrow(() -> new CustomException(NOT_FOUND_USER));

    if (member.isVerify()) {
      throw new CustomException(ALREADY_VERIFY);
    } else if (!member.getVerificationCode().equals(code)) {
      throw new CustomException(WRONG_VERIFICATION);
    } else if (member.getVerificationExpiredAt().isBefore(LocalDateTime.now())) {
      throw new CustomException(EXPIRED_CODE);
    }
    member.setVerify(true);
  }

  @Transactional
  public LocalDateTime changeMemberValidateEmail(Long memberId, String verificationCode) {
    Optional<Member> memberOptional = memberRepository.findById(memberId);

    if (memberOptional.isPresent()) {
      Member member = memberOptional.get();

      member.setVerificationCode(verificationCode);
      member.setVerificationExpiredAt(LocalDateTime.now().plusDays(1));

      return member.getVerificationExpiredAt();

    } else {
      throw new CustomException(NOT_FOUND_USER);
    }
  }


}
