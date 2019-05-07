package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TheHelloWorld {
    public static void main(String[] args) {

        System.out.println(solution("the hello world"));
    }

    public static String solution(String words) {
        return Arrays.stream(words.split(" "))
                .map(word -> {
                    String[] chars = word.split("");
                    String result = "";
                    int idx = 0;
                    for (String s : chars) {
                        if(idx % 2 == 1){
                            result += s.toUpperCase();
                        }else{
                            result += s.toLowerCase();
                        }

                        idx++;
                    }

                    return result;
                })
                .collect(Collectors.joining( " "));
    }
}
