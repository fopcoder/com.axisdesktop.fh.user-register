package com.eazegames.test;

import org.junit.jupiter.api.Test;
import com.eazegames.app.DataGenerator;

class DataGeneratorTest {

  @Test
  void test_001() {
    System.err.println(DataGenerator.generateEmail(10));
  }

  @Test
  void test_002() {
    System.err.println(DataGenerator.generateRandomAlphaNumeric(10));
  }

  @Test
  void test_003() {
    System.err.println(DataGenerator.generateRandomString(10));
  }
}
