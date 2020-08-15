package com.company;

public class Pokies {
    Roll[] slots;

    public Pokies() {
        slots = new Roll[3];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Roll();
        }
    }

    public boolean play() throws InterruptedException {
        for (int i = 0; i < slots.length; i++) {
//            Thread.sleep(10);
            int finalI = i;
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                slots[finalI].roll();
                            } catch (Exception e) {
                            }
                        }
                    }
            ).start();
        }
        Thread.sleep(100);
        if (slots[0].slot == slots[1].slot && slots[0].slot == slots[2].slot)
            return true;
        else
            return false;

    }

    public void show() {
        System.out.println();
        for (int i = 0; i < slots.length; i++) {
            System.out.print(slots[i] + " ");
        }
    }
}
