package codility;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        //1
        //String S = "{[()()]}";
        //0
        String S = "([)()]";

        System.out.println(solution(S));
    }

    //문자 S가 주어졌을때 "{}", "[]", "()"각각의 괄호가 짝이 맞는지 확인후 맞으면 1 아니면 0
    public static int solution(String S) {
        Stack<String> stack = new Stack<>();

        String lastChar;
        for (int i = 0; i < S.length(); i++) {
            lastChar = String.valueOf(S.charAt(i));
            if ("{".equals(lastChar) || "[".equals(lastChar) || "(".equals(lastChar)) {
                stack.push(lastChar);
            } else {
                if (stack.isEmpty()){
                    return 0;
                }

                if ("}".equals(lastChar) && !"{".equals(stack.pop())) {
                    return 0;
                }

                if ("]".equals(lastChar) && !"[".equals(stack.pop())) {
                    return 0;
                }

                if (")".equals(lastChar) && !"(".equals(stack.pop())) {
                    return 0;
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
