package com.company;

import java.util.Random;

public class Roll {
    Digit slot;

    public void roll()
    {
        Random random = new Random(System.nanoTime());
        slot = Digit.values()[random.nextInt(5)];
    }

    @Override
    public String toString() {
        return ""+slot;
    }
}
