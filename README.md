Добавил
- ChromeUserActivator, FakeUserActivator, UserActivator
- в App процесс активации


-----------------------

Добавить либы из /lib

- common-codec
- jackson-*
- java-jwt

Добавлен класс
Token, TokenTest

------------------

Добавлено

- UserLoginer - общий интерфейс
- ChromeUserLoginer - заполнить как надо для логина на страницу
- FakeUserLoginer - для теста
- в App добавлен цикл // login users

----------------------------
Запуск 

cd utils
java -jar register.jar

В DataGenerator 
- переделал методы на статические для удобства
- поправил генерацию емейла, параметр - теперь длина логина, а не всего емейла

UserCreator - теперь интерфейс, чтобы можно было делать разные реализации не переделывая программу и метод генерации юзеров
CromeUserCreator - ваш класс UserCreator
FakeUserCreator, GoogleUserCreator - мои реализации для теста

Параметры сайта и драйвер прописываются в самом классе, так как все равно реализации createUser каждого конкретного сайта зависит от верстки

Выход из программы: "q", "quit", "exit"

Юзера выводятся в CSV формате
