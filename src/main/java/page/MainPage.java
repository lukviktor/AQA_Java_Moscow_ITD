package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static data.DataAutorization.*;

public class MainPage {


    private final SelenideElement btnLogin = $x("//li[@id='login']"); // Кнопка логин

    // Поле имя пользователя
    private final SelenideElement inputUserName = $x("//input[@id='username-modal']");

    // Поле пароль пользователя
    private final SelenideElement inputPassword = $x("//input[@id='password-modal']");


    // гипертекстовая ссылка залогиненого пользователя
    private final SelenideElement hrefBtnLogin = $x("//li[@id='howdy']/a");

    // Кнопка регистрации
    private final SelenideElement btnRegister = $x("//a[@data-target='#register-modal']");

    // Кнопка выход из системы
    private final SelenideElement btnLogout = $x("//a[@onclick='logout()']");

    // Дропдаун категории
    private final SelenideElement dropdownCategory = $x("//a[@class='dropdown-toggle']");

    /**
     * поля ввода для регистрации
     */
    private final SelenideElement registerUserName = $x("//input[@id='register-username-modal']");
    private final SelenideElement registerFirstName = $x("//input[@id='register-first-modal']");
    private final SelenideElement registerLastName = $x("//input[@id='register-last-modal']");
    private final SelenideElement registerEmail = $x("//input[@id='register-email-modal']");
    private final SelenideElement registerPassword = $x("//input[@id='register-password-modal']");
    private final SelenideElement btnRegisterNewUser = $x("//*[@id='register-modal']//button[@class='btn btn-primary']");

    @Step
    public MainPage registerNewUser(String userName, String firstName, String lastName, String email, String password) {
        btnRegister.click();
        registerUserName.setValue(userName);
        registerFirstName.setValue(firstName);
        registerLastName.setValue(lastName);
        registerEmail.setValue(email);
        registerPassword.setValue(password);
        btnRegisterNewUser.click();
        return new MainPage();
    }

    @Step("Авторизация пользователем")
    public MainPage authorizationUser(String userName, String password) {
        btnLogin.click();
        inputUserName.setValue(userName);
        inputPassword.setValue(password).pressEnter();
        return new MainPage();
    }

    @Step("Проверка что пользователь авторизовался")
    public boolean checkAuthorization() {
        return btnLogout.isDisplayed();
        // hrefBtnLogin.shouldHave(textCaseSensitive("Logged in as"));
    }

    @Step("Перейти в категории товаров")
    public CategoryPage goCategory() {
        dropdownCategory.click();
        return new CategoryPage();
    }


}
