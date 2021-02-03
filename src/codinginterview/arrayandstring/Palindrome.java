package codinginterview.arrayandstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 회문 순열
 * 회문 : 앞으로 읽으나, 뒤로 읽으나 같은 문자열
 * 순열 : 문자열을 재배치하는것
 *
 * 풀이법
 * 1. 거의 모든 문자열의개수가 짝수여야 하며, 하나의 문자만 홀수여야한다.
 * -> 하나의 문자를 기준으로 양쪽에 배치하여야 하니깐.
 *
 * 2. 문자열의 개수가 짝수면 모든 문자열짝이 짝수, 홀수일경우 하나의 문자만 홀수여야한다.
 *
 * 문자열을 훑어가면서 홀수인지 체크하는 방법도 좋다.
 */
public class Palindrome {
    public static void main(String[] args) {
        // 회문 : 앞으로읽으나, 뒤로 읽으나 같은 문자열
        // 순열이란 문자열을 재배치 하는것을 뜻한다.
        String s = "Tact coa";
        //String s = "a plan";
        //a plan

        Map<String, Integer> wordMap = new HashMap<>();
        String word;
        for (int i = 0; i < s.length(); i++) {
            word = String.valueOf(s.charAt(i)).toLowerCase();
            if (" ".equals(word)) {
                continue;
            }

            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        wordMap.forEach((s1, integer) -> System.out.println(s1 + " : " + integer));

        int oddCount = 0;
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }

            if(oddCount > 1){
                break;
            }
        }

        if (oddCount > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

}
