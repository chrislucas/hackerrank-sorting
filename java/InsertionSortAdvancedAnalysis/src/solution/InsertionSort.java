package solution;

import java.util.Random;

public class InsertionSort {

    private static boolean lessThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static  void swap(Comparable [] data, int i , int j) {
        Comparable aux = data[i];
        data[i] = data[j];
        data[j] = aux;
    }

    private static void insertionSort(Comparable data[]) {
        for (int i = 1; i < data.length ; i++) {
            for (int j = i; j>0 && lessThan(data[j], data[j-1]); j--) {
                swap(data, j, j-1);
            }
        }
    }

    private static void test() {
        Random random = new Random();
        int n =random.nextInt(40) + 30;
        Integer [] set = new Integer[n];
        for (int i = 0; i < n ; i++) {
            set[i] = i;
        }
        for (int i = 0; i < n ; i++) {
            int idx = random.nextInt(n - i) + i;
            swap(set, i, idx);
        }
        for (int i = 0; i < n ; i++) {
            System.out.printf(i == 0 ? "%d" : " %d", set[i]);
        }
        System.out.println("");
        insertionSort(set);
        for (int i = 0; i < n ; i++) {
            System.out.printf(i == 0 ? "%d" : " %d", set[i]);
        }
    }


    public static void main(String[] args) {
        test();

    }
}
