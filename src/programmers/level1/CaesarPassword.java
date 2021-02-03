package programmers.level1;

public class CaesarPassword {
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));
    }

    public static String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if (s.charAt(i) == 32) {
                sb.append(" ");
            } else {
                if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                    if (s.charAt(i) + n > 90) {
                        sb.append((char) (64 + (s.charAt(i) + n) - 90));
                    } else {
                        sb.append((char) (s.charAt(i) + n));
                    }
                }

                if (97 <= s.charAt(i) && s.charAt(i) <= 122) {
                    if (s.charAt(i) + n > 122) {
                        sb.append((char) (96 + (s.charAt(i) + n) - 122));
                    } else {
                        sb.append((char) (s.charAt(i) + n));
                    }
                }
            }
        }

        return sb.toString();
    }
}
