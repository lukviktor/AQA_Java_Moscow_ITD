package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage {

    // Выбрать показано 9 из 9 товаров
    private final SelenideElement productsShowing_9 = $x("//a[@onclick='setNewPageSize(9)']");

    // добавление в корзину товара Holy
    private final SelenideElement productsCartHoly = $x("//*[@id='products']/div[1]/div/div[2]/p[2]/a[2]");

    // добавление в корзину товара Colourful
    private final SelenideElement productsCartColourful = $x("//*[@id='products']/div[2]/div/div[2]/p[2]/a[2]");

    // Элемент корзина
    private final SelenideElement itemsInCart = $x("//span[@id='numItemsInCart']");

    // Коллекция элементов товаров
    private final ElementsCollection productsCart = $$x("//p[@class='buttons']/a[@href='#']");

    //создаем список, в который поместим ссылки на продукты магазина
    List<String> links = new ArrayList<>();

    @Step("Добавление в корзину случайных продуктов")
    public void setLinksProduct() {
        IntStream.iterate(productsCart.size() - 1, i -> i >= 0, i -> i - 1).forEach(i -> productsCart.get(i).click());
    }

    @Step("Добавление товаров")
    public void addingAllItemShoppingCart() {
        productsShowing_9.click();
        setLinksProduct();
        itemsInCart.click();
    }

    @Step("Добавление товаров и переход в корзину")
    public void addingItemShoppingCart() {
        productsShowing_9.click();
        productsCartHoly.click();
        productsCartColourful.click();
        itemsInCart.click();
    }


}
