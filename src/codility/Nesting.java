package codility;

import java.util.Stack;

public class Nesting {

    public static void main(String[] args) {
        //String S = "(()(())())";//1
        //String S = "())";//0
        //String S = "";//1
        //String S = "(U)";//1
        String S = "VW";//1
        System.out.println(solution(S));
    }

    public static int solution(String S) {
        if(S.indexOf("(") == - 1){
            return 1;
        }

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
