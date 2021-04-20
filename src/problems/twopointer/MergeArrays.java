package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeArrays {

    public static void main(String[] args) {
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(-4);
//        a.add(3);
//
//        ArrayList<Integer> b = new ArrayList<>();
//        b.add(-2);
//        b.add(-2);
//
//        Set<int[]> res= new HashSet<>();

        int[] temp={1,1,1,2};

        System.out.println(Arrays.toString(temp));


       // new MergeArrays().merge(a, b);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int m = a.size();
        int n = b.size();

        if (m == 0) {
            a.addAll(b);
            return;
        }

        if (n == 0)
            return;

        for (int i = 0; i < n; i++)
            a.add(0);

        int k = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (a.get(m) > b.get(n)) {
                int val = a.get(m);
                a.set(k, val);
                m--;
                k--;
            } else {
                int val = b.get(n);
                a.set(k, val);
                n--;
                k--;
            }

        }

        int val = -1;
        while (m >= 0) {
            val = a.get(m);
            a.set(k, val);
            k--;
            m--;
        }

        while (n >= 0) {
            val = b.get(n);
            a.set(k, val);
            k--;
            n--;
        }
    }
}
