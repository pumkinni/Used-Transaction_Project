package com.example.usedtransaction.applicatioin;


import com.example.usedtransaction.client.MailgunClient;
import com.example.usedtransaction.client.mailgun.SendMailForm;
import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.exception.CustomException;
import com.example.usedtransaction.exception.ErrorCode;
import com.example.usedtransaction.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpApplication {

  private final MailgunClient mailgunClient;
  private final SignUpService signUpService;

  public void customerVerify(String email, String code) {
    signUpService.verifyEmail(email, code);
  }

  public String signUp(SignUpForm form) {
    if (signUpService.isEmailPresent(form.getEmail())) {
      throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);

    } else {
      Member m = signUpService.signUp(form);

      String code = getRandomCode();

      SendMailForm sendMailForm = SendMailForm.builder()
          .from("test1@test.com")
          .to(form.getEmail())
          .subject("Verification Email!")
          .text(getVerificationEmailBody(m.getEmail(), m.getNickname(), code))
          .build();

      ResponseEntity response = mailgunClient.sendEmail(sendMailForm);

      signUpService.changeMemberValidateEmail(m.getId(), code);

      return "회원가입에 성공하였습니다.";
    }

  }

  private String getRandomCode() {
    return RandomStringUtils.random(10, true, true);
  }

  private String getVerificationEmailBody(String email, String name, String code) {
    StringBuilder builder = new StringBuilder();
    return builder.append("Hello").append(name).append("! Please Click Link for verification.\n\n")
        .append("http://localhost:8081/signup/verify/member?email=")
        .append(email)
        .append("&code=")
        .append(code).toString();

  }


}
