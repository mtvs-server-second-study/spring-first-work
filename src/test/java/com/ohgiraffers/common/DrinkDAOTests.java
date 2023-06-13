package com.ohgiraffers.common;

import com.ohgiraffers.section.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class DrinkDAOTests {

    @Autowired
    private DrinkDAO drinkDAO;

    @Test
    @DisplayName("거스름돈이 제대로 반환 되는지 확인")
    public void testChangeDrinkDAO() {

        //given
        String name = "코카콜라";
        int money = 1000;

        //when & then
        assertThrows(
                IllegalArgumentException.class,
                () -> drinkDAO.changeDrink(name, money));

    }

    @Test
    @DisplayName("구매 시 거스름돈이 얼마인지 확인")
    public void testChangeDrinkDAO2() {

        //given
        int money = 3000;
        String name = "코카콜라";

        //when
        int changeDrink = drinkDAO.changeDrink(name, money);

        //then
        assertEquals(1000, changeDrink);
    }

    @DisplayName("음료이름을 입력하면 그에 해당하는 재고가 출력되는지?")
    @Test
    public void testFindAmountByName1() {

        // given
        String name = "비락식혜";

        // when
        int checkAmount = drinkDAO.findAmountByName(name);

        // then
        assertEquals(3, checkAmount);
    }

    @DisplayName("음료이름을 입력하면 그에 해당하는 재고가 0일때 예외가 발생하는지")
    @Test
    public void testFindAmountByName2() {

        // given
        String name = "밀키스";

        // when & then 예외처리 테스트 구문
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> drinkDAO.findAmountByName(name)
        );
    }

    @DisplayName("음료를 구매했을때 재고 수량이 1 감소하는지")
    @Test
    public void testUpdateAmount() {

        //given
        String name = "코카콜라";
        //when
        int result = drinkDAO.updateAmount(name);

        //then
        assertEquals(2, result);
    }
}
