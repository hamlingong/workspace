package com.hamlin.algorithm;

public class SortExchange {
    public static void test() {
        SortExchange sort = new SortExchange();
        int data[] = {1, 4, 5, 7, 9, 12, 15, 46};
        sort.exchange(data, 8);
    }

    private void exchange(int[] data, int length) {
        int count = 0;
        for (int i = 0; i < length / 2; i++) {
            System.out.println(" ---data: " + data[i]);
            System.out.println(" ---data % 2: " + (data[i] % 2));
            if ((data[i] % 2) == 0) {
                do {
                    System.out.println(" ---data[length -i] % 2---- " + (data[length - i - 1] % 2));
                    if ((data[length - count - 1] % 2) != 0) {
                        System.out.println(" ---data[i]---- " + data[i]);
                        System.out.println(" ---data[length -i]---- " + data[length -i -1]);
                        int tmp = data[i];
                        data[i] = data[length -i -1];
                        data[length -i -1] = tmp;
                        break;
                    }
                    System.out.println(" ---data[i]---- " + data[i]);
                    System.out.println(" ---data[length -i -1]---- " + data[length -i -1]);
                    length--;
                    count ++;
                } while ((data[length - i - 1] % 2) == 0);
                int tmp = data[i];
                data[i] = data[length -i -1];
                data[length -i -1] = tmp;
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("data: " + data[i]);
        }
    }
}
