package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DrinkDAO {

    private final Map<String, Drink> drinkMap;

    public DrinkDAO() {
        this.drinkMap = new HashMap<>();

        this.drinkMap.put("코카콜라", new Drink("코카콜라", 2000, 3));
        this.drinkMap.put("밀키스", new Drink("밀키스",2500, 0));
        this.drinkMap.put("비락식혜", new Drink("비락식혜", 1500, 3));
    }

    public Drink findMemberBySequence(String name) {

        return drinkMap.get(name);
    }

    public int changeDrink(String name, int money) {

        int drinkPrice = drinkMap.get(name).getPrice();
        if(drinkPrice > money) {
            throw new IllegalArgumentException("돈이 부족합니다");
        }

        return money - drinkPrice;
    }

    /* 재고 조회 기능 */
    public int findAmountByName(String name) {
        int result = drinkMap.get(name).getAmount();

        if (result == 0) {
            checkZero();
        }

        return result;
    }

    private static void checkZero() {
        throw new IllegalArgumentException("해당 음료는 재고가 없습니다.");
    }

    /* 재고 반영 기능 */
    public int updateAmount(String name) {

        Drink updateDrink = drinkMap.get(name);
        int amount = updateDrink.getAmount();
        updateDrink.setAmount(amount - 1);
        int result = drinkMap.get(name).getAmount();

        return result;
    }

}
