package e2e;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.BasketPage;
import page.MainPage;

import static data.DataAuthorization.*;

/**
 * тест по авторизации и добавления товара в корзину.
 */
public class AuthorizationAddProductShoppingCartTest extends BaseSelenideTest {

    @AfterEach
    public void clearBasket() {
        BasketPage basketPage = new BasketPage();
        basketPage.dellElementBasket();
    }

    @DisplayName("Авторизации и добавления товара в корзину")
    @Description("Пользователь авторизован. Добавление выбранных товаров. " +
            "Проверить что сумма цены товаров в корзине соответствует сумме цен заказанных товаров.")
    @Test
    public void testAddToCart() {
        MainPage mainPage = new MainPage();
        mainPage.authorizationUser(USER_NAME, PASSWORD)
                .goCategory().addingItemShoppingCart();

        BasketPage basketPage = new BasketPage();
        Assertions.assertEquals(basketPage.totalColumnPrise(), basketPage.actualPrise(), 0.0001);
    }

    @DisplayName("Авторизации и добавления товара в корзину")
    @Description("Пользователь авторизован. Добавление всех товаров находящихся на странице. " +
            "Проверить что сумма цены товаров в корзине соответствует сумме цен заказанных товаров.")
    @Test
    public void testAddToCartAll() {
        MainPage mainPage = new MainPage();
        mainPage.authorizationUser(USER_NAME, PASSWORD).goCategory().addingAllItemShoppingCart();

        BasketPage basketPage = new BasketPage();
        Assertions.assertEquals(basketPage.totalColumnPrise(), basketPage.actualPrise(), 0.0001);
    }

    @DisplayName("Регистрация, авторизации и добавления товара в корзину")
    @Description("Добавление выбранных товаров. " +
            "Проверить что сумма цены товаров в корзине соответствует сумме цен заказанных товаров.")
    @Test
    public void testRegisterAddToCart() {
        MainPage mainPage = new MainPage();
        mainPage.registerNewUser(USER_NAME_RANDOM,
                        USER_FIRST_NAME_RANDOM,
                        USER_LAST_NAME_RANDOM,
                        USER_EMAIL_RANDOM,
                        USER_PASSWORD_RANDOM)
                .goCategory().addingItemShoppingCart();

        BasketPage basketPage = new BasketPage();
        Assertions.assertEquals(basketPage.totalColumnPrise(), basketPage.actualPrise(), 0.0001);
    }

    @DisplayName("Добавления товара в корзину")
    @Description("Добавление выбранных товаров. " +
            "Проверить что сумма цены товаров в корзине соответствует сумме цен заказанных товаров.")
    @Test
    public void testNotRegisterAddToCart() {
        MainPage mainPage = new MainPage();
        mainPage.goCategory().addingItemShoppingCart();

        BasketPage basketPage = new BasketPage();
        Assertions.assertEquals(basketPage.totalColumnPrise(), basketPage.actualPrise(), 0.0001);
    }
}