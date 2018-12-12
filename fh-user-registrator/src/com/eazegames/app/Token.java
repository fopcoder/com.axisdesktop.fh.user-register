package com.eazegames.app;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class Token {
  private String email;
  private String key;
  private Duration expire = Duration.ofDays(1);

  public Token(String key, String email) {
    this(email, key, null);
  }

  public Token(String key, String email, Duration expire) {
    if (email == null || key == null)
      throw new IllegalArgumentException("email or key is null!");

    this.email = email;
    this.key = key;

    if (expire != null)
      this.expire = expire;
  }

  public String create() {
    LocalDateTime dt = LocalDateTime.now().plus(expire);
    String exp = String.valueOf(dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

    Algorithm alg = Algorithm.HMAC256(key);

    Date exp1 = Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());

    String token = JWT.create()//
        .withSubject(email)//
        .withExpiresAt(exp1)//
        .sign(alg);

    return token;
  }

  // {"alg":"HS256"}
  // {"sub":"valeraignat2020@gmail.com","exp":1544696700}
  // clientId=EAZ8039ID

  // https://eazegames.com/email-verification-success?clientId=EAZ8039ID&token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2YWxlcmFpZ25hdDIwMjBAZ21haWwuY29tIiwiZXhwIjoxNTQ0Njk2NzAwfQ.89on1X4W-vjpNEN1Vxm8XmP9JNsn6U_LA48J0cM9dzI
}
