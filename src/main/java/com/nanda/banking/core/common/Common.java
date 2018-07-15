package com.nanda.banking.core.common;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;

public class Common {
    public static Long getGeneratedLong(){
        return new RandomDataGenerator().nextLong(9999999L,99999999L);
    }
}
