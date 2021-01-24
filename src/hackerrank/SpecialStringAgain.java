package hackerrank;

public class SpecialStringAgain {
    public static void main(String[] args) {
        String s = "aaaa";


        // 1. idx기준으로 문자열 leng까지 중간문자열 기준으로 나눠서
        // 2. split된, 문자열 전, 후가 같은지 확인
        int count = 0;
        String prev = "", next = "";
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                prev = s.substring(i, j);

                if (prev.length() < arr.length - j) {
                    next = s.substring(j + 1, j + 1 + prev.length());
                } else {
                    break;
                }

                if(prev.equalsIgnoreCase(next)){
                    count++;
                }
                System.out.println(String.format("prev = %s, next = %s", prev, next));
            }
        }

        System.out.println(count + s.length());
    }
}
