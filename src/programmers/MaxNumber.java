package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * <p>
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * <p>
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * <p>
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *
 * 입출력 예
 * numbers	return
 * [6, 10, 2]	6210
 * [3, 30, 34, 5, 9]
 */
public class MaxNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        //9534330
        System.out.println(solution(numbers));


        System.out.println("-------------------");




        int n = numbers.length;
        int[] combArr = new int[n];
        doCombination(combArr, n, n, 0, 0, numbers);
    }

    public static String solution(int[] numbers) {

        //int[] numbers1 = Arrays.stream(numbers).filter(i -> i < 10).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        //int[] numbers2 = Arrays.stream(numbers).filter(i -> i >= 10).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        //int[] concatNumbers = Stream.concat(Arrays.stream(numbers1).boxed(), Arrays.stream(numbers2).boxed()).mapToInt(Integer::intValue).toArray();
        int[] sortedNumbers = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        String sum = "";
        for (int i = 9; i >= 1; i--) {
            for (int number : sortedNumbers) {
                int checkNum = Integer.parseInt(String.valueOf(number).substring(0, 1));

                if(i == checkNum){
                    sum += String.valueOf(number);
                }
            }
        }

        return sum;
    }


    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        if(r == 0){
            for(int i=0; i<index; i++) System.out.print(arr[combArr[i]] + " ");
            System.out.println();
        }else if(target == n) return;
        else{
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
            doCombination(combArr, n, r, index, target+1, arr); //(ii)
        }
    }
}
