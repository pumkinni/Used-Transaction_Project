package com.example.usedtransaction.client;

import com.example.usedtransaction.client.mailgun.Service.EmailSendService;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailgunClientTest {

  @Autowired
  private EmailSendService emailSendService;

  @Test
  void EmailTest() {
      //given
      //when
      //then

    String response = emailSendService.sendEmail();
  }


}