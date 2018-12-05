package com.eazegames.app;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {
  public static String generateRandomString(int length) {
    return RandomStringUtils.randomAlphabetic(length);
  }

  public static String generateRandomAlphaNumeric(int length) {
    return RandomStringUtils.randomAlphanumeric(length);
  }

  public static String generateEmail(int length) {
    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
        "1234567890";

    String temp = RandomStringUtils.random(length, allowedChars);
    // email = temp.substring(0, temp.length() - 9) + "@gmail.com";
    String email = temp + "@gmail.com";

    return email;
  }

}
