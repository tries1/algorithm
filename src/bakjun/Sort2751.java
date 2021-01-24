package bakjun;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sort2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        SortedSet<Integer> integerSortedSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            integerSortedSet.add(sc.nextInt());
        }

        StringBuffer sb = new StringBuffer();
        integerSortedSet.forEach(integer -> sb.append(integer + "\n"));

        System.out.println(sb.toString());
    }
}