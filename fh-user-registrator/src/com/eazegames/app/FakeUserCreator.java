package com.eazegames.app;

public class FakeUserCreator implements UserCreator {

  @Override
  public UserInfo createUser() {
    UserInfo userInfo = new UserInfo();

    String userEmail = DataGenerator.generateEmail(10);
    userInfo.setEmail(userEmail);

    String pass = DataGenerator.generateRandomString(20);
    userInfo.setPassword(pass);

    String userName = DataGenerator.generateRandomAlphaNumeric(15);
    userInfo.setUsername(userName);

    return userInfo;
  }

}
