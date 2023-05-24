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
import lombok.Setter;
import org.hibernate.envers.AuditOverride;

@Entity
@Getter
@Setter
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
  @Column
  private String password;
  @Column
  private boolean deleted;
  @Column
  private LocalDateTime deletedAt;
  @Column
  private boolean verify;
  @Column
  private String verificationCode;
  @Column
  private LocalDateTime verificationExpiredAt;
  // like list 추가(post 테이블 생성 후)


  public static Member from(SignUpForm form) {
    return Member.builder()
        .email(form.getEmail())
        .nickname(form.getNickname())
        .password(form.getPassword())
        .verify(false)
        .deleted(false)
        .build();
  }


}
