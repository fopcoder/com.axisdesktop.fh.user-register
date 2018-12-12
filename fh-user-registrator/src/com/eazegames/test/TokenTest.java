package com.eazegames.test;

import org.junit.jupiter.api.Test;
import com.eazegames.app.Token;

class TokenTest {

  @Test
  void test() {
    Token token = new Token("111-key", "test@mail.com");
    System.err.println(token.create());
  }

}
