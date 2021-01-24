package hackerrank;

import java.util.Arrays;

public class TwoStrings {
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";

        boolean result = false;
        String[] aArr = Arrays.stream(a.split("")).distinct().toArray(String[]::new);
        String[] bArr = Arrays.stream(b.split("")).distinct().toArray(String[]::new);
        for (int i = 0; i < bArr.length; i++) {
            for (int j = 0; j < aArr.length; j++) {
                if (bArr[i].equalsIgnoreCase(aArr[j])) {
                    result = true;
                    break;
                }
            }

            if (result) {
                break;
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
