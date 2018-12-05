package com.eazegames.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeUserCreator implements UserCreator {
  private WebDriver webDriver;
  private String webDriverPath = "C:\\Users\\1\\Downloads\\chromedriver_win32\\chromedriver.exe";
  // private WebDriverWait wait;

  public ChromeUserCreator() {
    System.setProperty("webdriver.chrome.driver", webDriverPath);
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("website");
  }

  public UserInfo createUser() {
    UserInfo userInfo = new UserInfo();

    String userEmail = DataGenerator.generateEmail(10);
    userInfo.setEmail(userEmail);

    String pass = DataGenerator.generateRandomString(20);
    userInfo.setPassword(pass);

    String userName = DataGenerator.generateRandomAlphaNumeric(15);
    userInfo.setUsername(userName);

    WebElement userField = webDriver.findElement(
        By.cssSelector(".st-form-field-wrapper input[id^=undefined-undefined-UserName]"));
    userField.click();
    userField.sendKeys(userName);

    WebElement emailUser = webDriver.findElement(By.id("email"));
    emailUser.click();
    emailUser.sendKeys(userEmail);

    WebElement userPass = webDriver
        .findElement(By.cssSelector(".st-form-field-wrapper input[id^=undefined-undefined-Pass]"));
    userPass.click();
    userPass.sendKeys(pass);

    WebElement privacyCheck = webDriver.findElement(By.id("privacy"));
    privacyCheck.click();

    WebElement adultCheck = webDriver.findElement(By.id("user-is-adult"));
    adultCheck.click();

    WebElement createAccountButton = webDriver.findElement(By.cssSelector(".over-button button"));

    createAccountButton.click();
    return userInfo;

  }
}
