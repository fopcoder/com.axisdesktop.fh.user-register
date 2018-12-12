package com.eazegames.app;

public class FakeUserActivator implements UserActivator {
  @Override
  public void activate(UserInfo user) {
    System.err.println("activate " + user.getUsername() + " " + user.getActivateToken());
  }
}
