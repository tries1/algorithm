package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Joystic {
    public static void main(String[] args) {
        //String name = "JAZ";//	11
        //String name = "JEROEN";//	56
        //String name = "JAN";//	23
        String name = "ABAAAAAAAAABB";//	7

        System.out.println(solution(name));
    }

    //▲ - 다음 알파벳
    //▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    //◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    //▶ - 커서를 오른쪽으로 이동
    public static int solution(String name) {
        int answer = 0;
        String[] findName = new String[name.length()];
        for (int i = 0; i < name.length(); i++) { findName[i] = "A"; }

        int front, back, left, right, upDownMin, leftRightMin;
        int curIdx = 0;
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZA";
        String[] nameArr = name.split("");

        while (!name.equals(Arrays.stream(findName).collect(Collectors.joining()))) {
            front = 0;
            back = 0;
            right = 0;
            left = 0;

            for (int i = curIdx; i < name.length(); i++) {
                if (!"A".equals(String.valueOf(name.charAt(i))) || curIdx == 0) {
                    break;
                }
                right++;
            }

            for (int i = curIdx; i >= 0; i--) {
                if (!"A".equals(String.valueOf(name.charAt(i))) || curIdx == 0) {
                    break;
                }

                if (i == 0){
                    i = name.length()-1;
                }

                left++;
            }

            for (int i = 0; i < alpha.length() - 1; i++) {
                if (nameArr[curIdx].equals(String.valueOf(alpha.charAt(i)))) {
                    break;
                }
                front++;
            }

            for (int i = alpha.length() - 1; i >= 0; i--) {
                if (nameArr[curIdx].equals(String.valueOf(alpha.charAt(i)))) {
                    break;
                }
                back++;
            }

            upDownMin = Math.min(front, back);
            leftRightMin = Math.min(left, right);
            answer = answer + upDownMin + leftRightMin;
            curIdx = (leftRightMin == 0) ? leftRightMin++ : leftRightMin;
        }


        return answer;

        /*int answer = 0;
        int front, back, left, right, min;
        int findIdx = 0;
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZA";
        String[] nameArr = name.split("");

        while (findIdx < name.length()) {
            front = 0;
            back = 0;
            right = 0;
            left = 0;

            for (int i = findIdx; i < name.length(); i++) {
                if (!"A".equals(String.valueOf(name.charAt(i)))) {
                    break;
                }
                right++;
            }

            for (int i = findIdx; i >= 0; i--) {
                if (!"A".equals(String.valueOf(name.charAt(i)))) {
                    break;
                }

                if (i == 0){
                    i = name.length()-1;
                }

                left++;
            }

            for (int i = 0; i < alpha.length() - 1; i++) {
                if (nameArr[findIdx].equals(String.valueOf(alpha.charAt(i)))) {
                    break;
                }
                front++;
            }

            for (int i = alpha.length() - 1; i >= 0; i--) {
                if (nameArr[findIdx].equals(String.valueOf(alpha.charAt(i)))) {
                    break;
                }
                back++;
            }

            min = Math.min(front, back);
            int min2 = Math.min(left, right);
            answer = answer + min + min2;
            findIdx++;
        }

        return answer;*/
    }
}
