package com.company;

public class Main {
    public static double result;
    public static boolean isFinished = false;
    public static int n = 0;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        final int N = 10;
        for (int i = 0; i <= N; i++) {

            threadTest();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!isFinished);

        long stop = System.currentTimeMillis();
        System.out.println("From main: " + result);
        System.out.println(stop - start);


        System.out.println("------------------------------------------------------------");
        Pokies pokie = new Pokies();
        for (int i = 0; i < 100; i++) {
            if (pokie.play())
                System.out.print ("\nCoins: ");
            pokie.show();
        }

    }

    public static void threadTest() {
        Thread thread = new Thread
                (
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    final double[] f1 = new double[3];

                                    f1[0] = 1;
                                    f1[1] = 1;
                                    f1[2] = 1;

                                    for (int i = 0; i < 1474; i++) {
                                        f1[2] = f1[0] + f1[1];
                                        f1[0] = f1[1];
                                        f1[1] = f1[2];
                                    }
                                    result = f1[2];

                                    isFinished = true;
                                    n++;
                                    // System.out.println(n + " From thread: " + f1[2]);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                );
        thread.setPriority((int) (1 + Math.random() * 10));
        thread.start();
    }
}
