package com.ohgiraffers.common;

import com.ohgiraffers.section.ContextConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}