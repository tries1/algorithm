package codinginterview.arrayandstring;

public class NoDuplicate {

    public static boolean isUniqueChar(String s) {
        if (s.length() > 128) {
            return false;
        }

        //아스키 기준으로 128개의 문자를 체크하는 배열을 생성
        boolean result = false;
        boolean[] checkArray = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (checkArray[val]) {
                result = true;
                break;
            } else {
                checkArray[s.charAt(i)] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "adqwacxcqdfgwdaczxgeopgper";
        //String s = "abcdefghijklmnopqrstuvwxyz";
        boolean isDuplicate = isUniqueChar(s);

        if (isDuplicate) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        //내 풀이
        boolean isDuplicate2 = false;
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(s.charAt(i));
            for (int j = i + 1; j < s.length() - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isDuplicate = true;
                    break;
                }

                if (isDuplicate) {
                    break;
                }
            }
        }

        if (isDuplicate) {
            //System.out.println("YES");
        } else {
            //System.out.println("NO");
        }

    }
}
