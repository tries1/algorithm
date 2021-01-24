package test;

public class Test1 {

    //수자
    public static void main(String[] args) {
        //100
        System.out.println(solution(125));
    }

    //숫자를 받으면 같은 자리수의 가장 작은수를 반황
    public static int solution(int N) {
        String strNumber = String.valueOf(N);

        if (strNumber.length() == 1){
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(strNumber.charAt(0));
        for (int i = 0; i < strNumber.length() - 1; i++) {
            sb.append(0);
        }

        return Integer.parseInt(sb.toString());
    }
}
