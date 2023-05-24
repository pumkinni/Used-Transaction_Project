package com.example.usedtransaction.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.usedtransaction.domain.SignUpForm;
import com.example.usedtransaction.domain.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SignUpServiceTest {
  @Autowired
  private SignUpService signUpService;

  @Test
  void signUp() {
      //given
      //when
      //then
    SignUpForm form = SignUpForm.builder().email("kmju4766@gmail.com")
        .password("1111")
        .nickname("kkmmjj")
        .build();

    Member m = signUpService.signUp(form);

    assertEquals(1, m.getId());
    assertEquals(form.getEmail(), m.getEmail());
    assertEquals(form.getPassword(), m.getPassword());
    assertEquals(form.getNickname(), m.getNickname());
    assertEquals(false, m.isVerify());
    assertFalse(m.isDeleted());
    assertNotNull(m.getReg_at());
    assertNotNull(m.getUpdated_at() );
  }

}