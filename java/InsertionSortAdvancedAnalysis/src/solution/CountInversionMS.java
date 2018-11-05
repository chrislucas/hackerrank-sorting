package solution;

import java.util.Random;

public class CountInversionMS {

    private static boolean lessThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static long merge(Comparable [] data, Comparable[] aux, int lo, int mi, int hi) {
        long acc = 0;
        System.arraycopy(data, lo, aux, lo, hi + 1 - lo);
        int i = lo, j = mi+1;
        for (int k = lo; k <= hi ; k++) {
            // se i maior que mi, todos os elementos antes de 'mi' ja foram posicionados no array, prencha o vetor apos mi
            if (i>mi)
                data[k] = aux[j++];
            // se j > hi os elementos apos o mi ja foram posicionados, preencha o vetor antes de mi
            else if (j>hi)
                data[k] = aux[i++];
            else if(lessThan(aux[j], aux[i])) {
                data[k] = data[j++];
                acc += (mi-lo+1);
            }
            else
                data[k] = aux[i++];
        }
        return acc;
    }

    private static long counting(Comparable [] data) {
        Comparable [] aux = new Comparable[data.length];
        //System.arraycopy(data, 0, aux, 0, data.length);
        return  counting(data, aux, 0, data.length-1);
    }

    private static long counting(Comparable [] data, Comparable [] aux, int lo, int hi) {
        long acc = 0;
        if (hi<=lo)
            return acc;
        int mi = (hi-lo)/2+lo;
        acc += counting(data, aux, lo, mi);
        acc += counting(data, aux, mi+1, hi);
        acc += merge(data, aux, lo, mi+1, hi);
        return acc;
    }

    private static  void swap(Comparable [] data, int i , int j) {
        Comparable aux = data[i];
        data[i] = data[j];
        data[j] = aux;
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
        System.out.printf("\n%d\n", counting(set));
        for (int i = 0; i < n ; i++) {
            System.out.printf(i == 0 ? "%d" : " %d", set[i]);
        }
    }

    private static void test2() {
        Integer [][] set = new Integer[][] {
            {2,1,3,1,2}
            ,{5,4,3,2,1}
        };
        int idx = 1;
        System.out.printf("\n%d\n", counting(set[idx]));
        for (int i = 0; i < set[idx].length ; i++) {
            System.out.printf(i == 0 ? "%d" : " %d", set[idx][i]);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
