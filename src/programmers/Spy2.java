package programmers;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * <p>
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * <p>
 * 종류    이름
 * 얼굴    동그란 안경, 검정 선글라스
 * 상의    파란색 티셔츠
 * 하의    청바지
 * 겉옷    긴 코트
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 * <p>
 * 입출력 예
 * clothes	return
 * [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
 * [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
 * 입출력 예 설명
 * 예제 #1
 * headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
 * <p>
 * 1. yellow_hat
 * 2. blue_sunglasses
 * 3. green_turban
 * 4. yellow_hat + blue_sunglasses
 * 5. green_turban + blue_sunglasses
 * 예제 #2
 * face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
 * <p>
 * 1. crow_mask
 * 2. blue_sunglasses
 * 3. smoky_makeup
 **/
public class Spy2 {
    public static void main(String[] args) {
        System.out.println("------------------");

        //String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};//expected 5
        //String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};//expected 3
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"blue_sunglasses2", "eyewear"}, {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};//expected 5

        System.out.println(solution(clothes));
    }

    /**
     * hint
     *
     * 예를들어 옷을 조합할때 옷이 3 부위 각각 1종류 2종류 3종류가 있으면
     * 1가지 부위 만 입는경우 (1+2+3),
     * 2가지 부위를 조합해 입는경우 (1*2)+(1*3)+(2*3),
     * 3가지 부위 조합 해입는경우 (1*2*3) 를 모두 더해야 ANSWER입니다.
     *
     */
    public static int solution(String[][] clothes) {
        //의상 종류별 카운트
        Map<String, Long> clothesTypeCntMap = Arrays.stream(clothes).collect(Collectors.groupingBy(s -> s[1], Collectors.counting()));
        clothesTypeCntMap.entrySet().stream().forEach(System.out::println);

        /*//의상수 만큼 입을수 있는 경우의수
        int sum = (clothesTypeCntMap.size() == 1) ? 0 : clothesTypeCntMap.size();//1개씩 입었을경우
        for (int i = 1; i <= clothesTypeCntMap.size(); i++) {
            sum += clothesTypeCntMap.entrySet().stream().limit(i).map(Map.Entry::getValue).reduce((l1, l2) -> l1 * l2).orElse(0L).intValue();
        }*/

        //의상수 만큼 입을수 있는 경우의수
        //1개입는 경우
        int sum1 = clothesTypeCntMap.entrySet().stream().map(Map.Entry::getValue).reduce((l1, l2) -> l1 * l2).orElse(0L).intValue();

        //2개입는 경우
        /*for (int i = 0; i < ; i++) {

        }*/

        int sum = (clothesTypeCntMap.size() == 1) ? 0 : clothesTypeCntMap.size();//1개씩 입었을경우
        for (int i = 1; i <= clothesTypeCntMap.size(); i++) {
            sum += clothesTypeCntMap.entrySet().stream().limit(i).map(Map.Entry::getValue).reduce((l1, l2) -> l1 * l2).orElse(0L).intValue();
        }

        return sum;
    }
}
