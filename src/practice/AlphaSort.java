package practice;

import java.util.Arrays;

/**
 * 문자열 비교시 compareTo는 사전적순서로 비교한다.
 */
public class AlphaSort {
    public static void main(String[] args) {
        String alpha = "kashdfuihfFISVSDFKFCaaaWOYWEFIHaVBWIAFAOIAaXCmzxnGgvdfahgtyuikambnmkoiDMLaKJggNdfsfhuaiwhVUGEHwetvavxIVMXASCDAPUCDPAJ";

        System.out.println("case 1 :");
        Arrays.stream(alpha.split(""))
                .sorted()
                .forEach(System.out::print);


        System.out.println();
        System.out.println("case 2 :");
        Arrays.stream(alpha.split(""))
                .sorted((o1, o2) -> {
                    int res = o1.compareToIgnoreCase(o2);
                    return (res == 0) ? o1.compareTo(o2) : res;
                })
                .forEach(System.out::print);

        System.out.println();
        System.out.println("case 3 :");
        Arrays.stream(alpha.split(""))
                .sorted((o1, o2) -> {
                    int res = o1.compareToIgnoreCase(o2);
                    return (res == 0) ? o2.compareTo(o1) : res;
                })
                .forEach(System.out::print);

    }
}
