package programmers;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

    제한사항
    마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
    completion의 길이는 participant의 길이보다 1 작습니다.
    참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    참가자 중에는 동명이인이 있을 수 있습니다.
*/
public class Marathon {
    public static void main(String[] args) {
        //[leo, kiki, eden]	[eden, kiki]	leo
        //[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
        //[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav

        //String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //String[] completion = {"stanko", "ana", "mislav"};
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        //System.out.println(solution(participant, completion));
        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMapCnt = Arrays.stream(participant).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> completionMapCnt = Arrays.stream(completion).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //lazy evaluation
        return participantMapCnt.entrySet().stream()
                .filter(entry -> (Optional.ofNullable(completionMapCnt.get(entry.getKey())).orElse(0L) - entry.getValue()) != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("");


        /*List<String> pList = Arrays.asList(participant);
        List<String> cList = Arrays.asList(completion);
        pList.stream().filter(s -> !cList.contains(s)).forEach(System.out::println);

        return pList.stream().filter(s -> !cList.contains(s)).findFirst().orElse("");*/
    }
}


