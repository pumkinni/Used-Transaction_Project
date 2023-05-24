package com.example.usedtransaction.controller;


import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import com.example.usedtransaction.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

  @Autowired
  private SignUpService signUpService;

  @PostMapping("/member/signup")
  public Member signUp(@RequestBody SignUpForm form) {
    return signUpService.signUp(form);
  }

}
