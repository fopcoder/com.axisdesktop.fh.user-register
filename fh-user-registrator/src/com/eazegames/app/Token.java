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
    Algorithm alg = Algorithm.HMAC256(key);
    Date exp = Date.from(dt.atZone(ZoneId.systemDefault()).toInstant());

    String token = JWT.create()//
        .withSubject(email)//
        .withExpiresAt(exp)//
        .sign(alg);

    return token;
  }
}
