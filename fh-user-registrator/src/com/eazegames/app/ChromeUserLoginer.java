package com.eazegames.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeUserLoginer implements UserLoginer {
  private WebDriver webDriver;
  private String webDriverPath = "C:\\Users\\1\\Downloads\\chromedriver_win32\\chromedriver.exe";
  // private WebDriverWait wait;

  public ChromeUserLoginer() {
    System.setProperty("webdriver.chrome.driver", webDriverPath);
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("website");
  }

  @Override
  public UserInfo login(UserInfo info) {
    String userEmail = info.getEmail();
    String pass = info.getPassword();

    WebElement loginField = webDriver.findElement(By.name("email"));
    loginField.sendKeys(userEmail);
    System.err.println(userEmail);

    WebElement passwordField = webDriver.findElement(By.name("password"));
    passwordField.sendKeys(pass);
    System.err.println(pass);

    WebElement loginButton = webDriver.findElement(By.tagName("button"));
    loginButton.click();

    // тут подождать ответа после редиректа и проверить что залогинились по какому либо элементу на
    // странице
    // заполнить loginSuccessElement если залогинились успешно

    // пример

    WebElement loginSuccessElement = null; // создаем пременную

    // try - чтобы не выкидывало по ошибке если элемент не найден
    try {
      loginSuccessElement = webDriver.findElement(By.id("id-of-success-page-element"));
    } catch (Exception e) {
    }

    return loginSuccessElement == null ? null : info;
  }

}
