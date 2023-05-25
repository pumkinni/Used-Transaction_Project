package com.example.usedtransaction.controller;


import com.example.usedtransaction.applicatioin.SignUpApplication;
import com.example.usedtransaction.domain.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

  private final SignUpApplication signUpApplication;

  @PostMapping
  public ResponseEntity<String> signUp(@RequestBody SignUpForm form) {
    return ResponseEntity.ok(signUpApplication.signUp(form));
  }

  @GetMapping("/verify/member")
  public ResponseEntity<String> verifyMember(String email, String code) {
    signUpApplication.customerVerify(email, code);
    return ResponseEntity.ok("인증이 완료되었습니다.");
  }

}
