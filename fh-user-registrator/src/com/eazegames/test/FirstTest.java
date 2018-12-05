package com.eazegames.test;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import com.eazegames.app.ChromeUserCreator;
import com.eazegames.app.UserCreator;
import com.eazegames.app.UserInfo;

class FirstTest {

  @Test
  public void userSignUp() {
    UserCreator userCreator = new ChromeUserCreator();
    UserInfo createdUser = userCreator.createUser();

    assertNotNull(createdUser);
    System.out.println("User was registered: email=" + createdUser.getEmail() + ", pass="
        + createdUser.getPassword() + ", username=" + createdUser.getUsername());
    assertNotNull(createdUser.getEmail());
    assertNotNull(createdUser.getPassword());
    assertNotNull(createdUser.getUsername());
  }
}
