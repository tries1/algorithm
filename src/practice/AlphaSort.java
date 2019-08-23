package practice;

import java.util.Arrays;

public class AlphaSort {
    public static void main(String[] args) {
        String alpha = "kashdfuihfFISVSDFKFCaaaWOYWEFIHaVBWIAFAOIAaXCmzxnvdfahgtyuikambnmkoiDMLaKJNdfsfhuaiwhVUEHwetvavxIVMXASCDAPUCDPAJ";

        System.out.println("case 1 :");
        Arrays.stream(alpha.split(""))
                .sorted()
                .forEach(System.out::print);


        System.out.println();
        System.out.println("case 2 :");
        Arrays.stream(alpha.split(""))
                .sorted((o1, o2) -> {
                    System.out.println(String.format("%s,%s = %s", o1, o2, o1.compareTo(o2)));
                    int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                    return (res == 0) ? o1.compareTo(o2) : res;
                })
                .forEach(System.out::print);

    }
}
