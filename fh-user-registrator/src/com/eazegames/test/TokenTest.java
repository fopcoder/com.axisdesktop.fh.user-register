package com.eazegames.test;

import org.junit.jupiter.api.Test;
import com.eazegames.app.Token;

class TokenTest {

  @Test
  void test() {
    Token token = new Token("test@mail.com", "111");
    System.err.println(token.create());
  }

}
