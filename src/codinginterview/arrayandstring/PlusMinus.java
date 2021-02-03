package codinginterview.arrayandstring;

public class PlusMinus {

    public static boolean oneEditAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEditInsert(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return oneEditInsert(s2, s1);
        }

        return true;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) {
                    return false;
                }

                found = true;
            }
        }

        return true;
    }

    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }

                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ple";
        String s2 = "pale";


        if (oneEditAway(s1, s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
