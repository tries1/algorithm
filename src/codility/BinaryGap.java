package codility;

import java.util.Arrays;

public class BinaryGap {
    public static void main(String[] args) {

        //5
        int question = 1041;
        System.out.println(solution(question));

        //0
        int question2 = 32;
        System.out.println(solution(question2));

        //2
        int question3 = 561892;
        System.out.println(solution(question3));
    }

    public static int solution(int N) {
        int answer = 0;
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        Integer[] binaryArr = Arrays.stream(binary.split("")).map(Integer::parseInt).toArray(Integer[]::new);


        int count = 0;
        for (int i = 0; i < binaryArr.length; i++) {
            if(i == 0 && binaryArr[i] == 1){
                continue;
            }

            if(binaryArr[i] == 1){
                if(answer < count){
                    answer = count;
                }

                count = 0;
            }

            if(binaryArr[i] == 0){
                count++;
            }
        }

        return answer;
    }

    // 10000010001
    // 000001000
    // split(1) => 0 arr
    // count longest
    /*public static int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);

        System.out.println("binary = " + binary);

        binary = binary.substring(1, binary.length() - 1);

        if (binary.indexOf("1") == -1) {
            return 0;
        }


        String[] arr = binary.split("1");
        for (String s : arr) {
            if (s.length() > answer) {
                answer = s.length();
            }
        }

        return answer;
    }*/
}
