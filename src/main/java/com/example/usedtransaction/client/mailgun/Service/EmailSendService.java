package com.example.usedtransaction.client.mailgun.Service;

import com.example.usedtransaction.client.MailgunClient;
import com.example.usedtransaction.client.mailgun.SendMailForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailSendService {

  private final MailgunClient mailgunClient;

  public String sendEmail() {
    SendMailForm form = SendMailForm.builder()
        .from("test1234@naver.com")
        .to("kmju1235@gmail.com")
        .subject("test mail service2")
        .text("test this")
        .build();

    return mailgunClient.sendEmail(form).getBody();
  }
}
