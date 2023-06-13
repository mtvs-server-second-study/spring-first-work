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
        this.drinkMap.put("비락식헤", new Drink("비락식혜", 1500, 3));
    }

    public Drink findMemberBySequence(String name) {

        return  drinkMap.get(name);
    }
}
