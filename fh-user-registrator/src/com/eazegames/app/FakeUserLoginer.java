package com.eazegames.app;

import java.util.Random;

public class FakeUserLoginer implements UserLoginer {

  @Override
  public UserInfo login(UserInfo info) {
    int i = new Random().nextInt(10);

    return i > 4 ? info : null;
  }

}
