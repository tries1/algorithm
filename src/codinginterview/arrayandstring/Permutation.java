package codinginterview.arrayandstring;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 2개의 문자가 서로 순열관계인지 확인라하.
 * 순열이란?
 * 서로 다른 n개의 원소에서 r개를 중복없이 골라 순서에 상관있게 나열하는 것을 n개에서 r개를 택하는 순열(順列)이라고 한다.
 * (같은 문자이고, 순서만 다른것)
 * <p>
 * 풀이법
 * 1. 우선 2개의 문자길이가 다르면 순열관계일수 없다.
 * 2. 정렬 : 2개의 문자가 같은문자로 구성되어있다면, 정렬하였을때 같은지 확인하면 된다.
 * 3. 문자열의 개수를 비교 : 각 문자가 동일한 개수로 구성되어있는지 비
 */
public class Permutation {

    public static boolean permutation(String a, String b) {
        if(a.length() != b.length()){
            return false;
        }

        //ASCII로 가정
        int[] letters = new int[128];
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            letters[b.charAt(i)]--;
            if (letters[b.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "abcdefgdwq";
        String b = "dwqgfedcba";

        if (permutation(a, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        //정렬하여 둘이같은지 비교
        a = Arrays.stream(a.split("")).sorted().collect(Collectors.joining());
        b = Arrays.stream(b.split("")).sorted().collect(Collectors.joining());

        if (a.equalsIgnoreCase(b)) {
            //System.out.println("YES");
        } else {
            //System.out.println("NO");
        }
    }
}
