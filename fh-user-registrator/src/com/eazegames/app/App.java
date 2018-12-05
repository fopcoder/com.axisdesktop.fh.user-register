package com.eazegames.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    App app = new App();

    // создаем одну из возможных реализаций UserCreator
    // UserCreator creator = new UserCreatorChrome();
    // UserCreator creator = new FakeUserCreator();
    UserCreator creator = new GoogleUserCreator();

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter number of users: ");

      while (scanner.hasNext()) {
        if (scanner.hasNextInt()) {
          int num = scanner.nextInt();

          if (num <= 0) {
            System.err.println("Number must be  > 0");
            continue;
          }

          System.out.println("Lets create " + num + " users..");

          try {
            List<UserInfo> users = app.createUsers(num, creator);

            for (UserInfo user : users) {
              System.out.println(user);
            }
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }

        } else {
          String str = scanner.next();

          if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("quit")
              || str.equalsIgnoreCase("exit")) {
            System.exit(0);
          } else {
            System.err.println("Wrong number: " + str);
          }
        }

        System.out.print("Enter number of users: ");
      }
    }

  }

  // создаем определенное кол-во юзеров
  // num - кол-во
  // creator - конкретная реализация UserCreator
  public List<UserInfo> createUsers(int num, UserCreator creator) {
    if (num <= 0)
      throw new IllegalArgumentException("num users must be > 0!");
    if (creator == null)
      throw new IllegalArgumentException("creator is null!");

    List<UserInfo> users = new ArrayList<>(num);

    for (int i = 0; i < num; i++) {
      users.add(creator.createUser());
    }

    return users;
  }
}
