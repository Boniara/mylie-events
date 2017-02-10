package com.bavuta.mylie.database.utils;

import java.util.Random;

/**
 * Created by bogdan on 12/19/2016.
 */
public class KeyGenerator {

    private Integer randomValue;

    public Integer getNewKey() {
        randomValue = 0;
        for(int i = 0; i < 8; i++) {
            randomValue = randomValue + new Random().nextInt();
            randomValue = randomValue * 10;
        }
        return randomValue;
    }
}
