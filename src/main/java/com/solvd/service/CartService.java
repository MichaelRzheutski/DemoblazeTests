package com.solvd.service;

import com.solvd.domain.Order;
import com.solvd.domain.enums.Orders;
import com.solvd.gui.components.OrderModal;
import com.solvd.gui.pages.CartPage;
import org.openqa.selenium.WebDriver;

import java.time.Month;
import java.time.Year;

public class CartService {
    public Order getOrder(Orders orders) {
        return new Order(
                orders.getName(),
                orders.getCountry(),
                orders.getCity(),
                Long.parseLong(orders.getCreditCard()),
                Month.valueOf(orders.getMonth().toUpperCase()),
                Year.parse(orders.getYear())
        );
    }

    public OrderModal createOrder(Order order, WebDriver driver) {
        CartPage cartPage = new CartPage(driver);
        OrderModal orderModal = cartPage.clickPlaceOrderButton();

        orderModal.typeName(order.getName());
        orderModal.typeCountry(order.getCountry());
        orderModal.typeCity(order.getCity());
        orderModal.typeCreditCard(order.getCreditCard());
        orderModal.typeMonth(order.getMonth());
        orderModal.typeYear(order.getYear());

        return orderModal;
    }
}
