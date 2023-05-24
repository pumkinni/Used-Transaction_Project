package com.example.usedtransaction.applicatioin;


import com.example.usedtransaction.client.MailgunClient;
import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.exception.ErrorCode;
import com.example.usedtransaction.exception.MemberException;
import com.example.usedtransaction.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpApplication {

  private final MailgunClient mailgunClient;
  private final SignUpService signUpService;

  public void signUp(SignUpForm form) {
    if (signUpService.isEmailPresent(form.getEmail())) {
      throw new MemberException(ErrorCode.ALREADY_REGISTER_USER);

    } else {
      Member m = signUpService.signUp(form);
    }

  }


}
