package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 * <p>
 * 제한 사항
 * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
 * 입출력 예
 * s	return
 * try hello world	TrY HeLlO WoRlD
 * 입출력 예 설명
 * try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.
 */
public class TheHelloWorld {
    public static void main(String[] args) {

        String a = "adwqdq bdwqdcd  dqwdefgh ijkl dqwd         mwdqdwno p qrs tuvwx yz               ";
        Arrays.stream(a.split(" ")).forEach(System.out::println);
        System.out.println(a.split(" ").length);
        System.out.println("----------------------");

        //limit : 배열을 몇개까지 생성할지 체크
        //-1은 공백도 포함해서 배열생성
        Arrays.stream(a.split(" ", -1)).forEach(System.out::println);
        System.out.println(a.split(" ", -1).length);
        System.out.println("----------------------");


        //try hello world
        //TrY HeLlO WoRlD
        //System.out.println(solution("try hello world"));
        System.out.println(solution("a bcd  efgh ijkl   mno p qrs tuvwx yz"));
    }

    public static String solution(String words) {
        return Arrays.stream(words.split(" ", -1))
                .map(word -> {
                    String[] chars = word.split("");
                    String result = "";
                    int idx = 0;
                    for (String s : chars) {
                        result += (idx % 2 == 0) ? s.toUpperCase() : s.toLowerCase();
                        idx++;
                    }

                    return result;
                })
                .collect(Collectors.joining(" "));
    }
}
