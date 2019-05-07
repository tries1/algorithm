package programmers;

public class isNumber {

    /**
     * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
     * <p>
     * <p>
     * a234	false
     * 1234	true
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {

        if(s.length() != 4 && s.length() != 6){
            return false;
        }

        boolean check = true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                check = false;
            }
        }


        return check;
    }
}
