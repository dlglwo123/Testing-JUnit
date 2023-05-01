package com.codestates.homework;

import com.codestates.helper.StampCalculator;
import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        int count = 3;
        int expected = 7;

        int actuallyResult = StampCalculator.calculateStampCount(count,expected);

        int expectedResult = 7;

        assertEquals(actuallyResult,expectedResult);
    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.

        Order order = new Order();

        OrderCoffee orderCoffee = new OrderCoffee();
        orderCoffee.setQuantity(3);
        int Order1 = orderCoffee.getQuantity();

        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(7);
        int Order2 = orderCoffee1.getQuantity();

        int expectedResult = Order1 + Order2;

        order.setOrderCoffees(List.of(orderCoffee,orderCoffee1));
        int actuallyResult = StampCalculator.calculateEarnedStampCount(order);

        assertEquals(expectedResult,actuallyResult);
    }
}
