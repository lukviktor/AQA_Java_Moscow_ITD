package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {
    // Получение списка цен товаров в корзине
    private final ElementsCollection cartPricesTotal = $$x("//tbody[@id='cart-list']//td[6]");

    // колеекция кнопок удаления товара с корзины
    private final ElementsCollection dellElementBasket = $$x("//i[@class='fa fa-trash-o']");

    // Кнопока удаления товара с корзины
    private final SelenideElement dellElementBasketOne = $x("//i[@class='fa fa-trash-o']");

    // Промежуточный итог заказа - цена товара без учера доставки
    private final SelenideElement orderSubTotal = $x("//th[@id='orderSubtotal']");

    @Step("Очистить элементы корзины")
    public void dellElementBasket() throws InterruptedException {

        for (int i = 0; i < dellElementBasket.size(); i++) {
            dellElementBasketOne.click();
            Thread.sleep(1000);
            if (dellElementBasket.size() != 0) {
                dellElementBasketOne.click();
            }
        }
    }

    @Step("Получение Промежуточный итог заказа actualPrise")
    public Double actualPrise() {
        return Double.parseDouble(orderSubTotal.getText().replaceAll("\\$", ""));
    }

    @Step("Подчет суммы выбранных товаров в колонке Total expectedPrise")
    public double totalColumnPrise() {

        try {
            Thread.sleep(2000); //задержка на 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> prises = new ArrayList<>();
        List<Double> cartPrises = new ArrayList<>();
        double expectedPrise = 0;

        for (int i = 0; i < cartPricesTotal.size(); i++) {
            prises.add(cartPricesTotal.get(i).getText().replaceAll("\\$", ""));
            cartPrises.add(Double.parseDouble(prises.get(i)));

            expectedPrise += cartPrises.get(i);
        }
        return expectedPrise;
    }
}