package com.eazegames.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeUserActivator implements UserActivator {
  private WebDriver webDriver;
  private String webDriverPath = "C:\\Users\\1\\Downloads\\chromedriver_win32\\chromedriver.exe";
  // private WebDriverWait wait;

  public ChromeUserActivator() {
    System.setProperty("webdriver.chrome.driver", webDriverPath);
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
  }

  @Override
  public void activate(UserInfo user) {
    webDriver.get(
        "https://alpha.test3495.eazegames.com/email-verification-success?clientId=EAZ8039ID&token="
            + user.getActivateToken());
  }

}
