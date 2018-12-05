package com.eazegames.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleUserCreator implements UserCreator {
  private WebDriver webDriver;
  private String webDriverPath =
      "C:\\Users\\coder\\Downloads\\chromedriver_win32\\chromedriver.exe";
  // private String webDriverPath = "C:\\Users\\1\\Downloads\\chromedriver_win32\\chromedriver.exe";
  private String website = "https://google.com";
  // private WebDriverWait wait;

  public GoogleUserCreator() {
    System.setProperty("webdriver.chrome.driver", webDriverPath);
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();

  }

  public UserInfo createUser() {
    webDriver.get(website);

    UserInfo userInfo = new UserInfo();

    String userEmail = DataGenerator.generateEmail(10);
    userInfo.setEmail(userEmail);

    String pass = DataGenerator.generateRandomString(20);
    userInfo.setPassword(pass);

    String userName = DataGenerator.generateRandomAlphaNumeric(15);
    userInfo.setUsername(userName);

    WebElement userField = webDriver.findElement(By.cssSelector("input.gLFyf.gsfi"));
    userField.click();
    userField.sendKeys(userName);

    WebElement createAccountButton =
        webDriver.findElement(By.cssSelector(".FPdoLc.VlcLAe input[name=btnK]"));

    createAccountButton.click();
    return userInfo;

  }
}
