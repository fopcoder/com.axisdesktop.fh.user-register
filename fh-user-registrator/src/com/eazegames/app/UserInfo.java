package com.eazegames.app;

public class UserInfo {
  private String email;
  private String password;
  private String username;
  private String key;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getActivateToken() {
    Token token = new Token(key, email);
    return token.create();
  }

  @Override
  public String toString() {
    return username + ";" + email + ";" + password;
  }

}
