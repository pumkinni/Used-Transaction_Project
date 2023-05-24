package com.example.usedtransaction.domain.model;


import com.example.usedtransaction.domain.SignUpForm;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AuditOverride(forClass = BaseEntity.class)
public class Member extends BaseEntity {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String nickname;
  @Column(unique = true)
  private String email;
  private String password;
  private boolean deleted;
  private LocalDateTime deletedAt;
  private boolean verify;
  private String verificationCode;
  private LocalDateTime verificationExpiredAt;

  public static Member from(SignUpForm form) {
    return Member.builder()
        .email(form.getEmail())
        .nickname(form.getNickname())
        .password(form.getPassword())
        .verify(false)
        .deleted(false)
        .build();
  }

  // like list 추가(post 테이블 생성 후)

}
