package programmers;

public class KakaoKeypad {
    public static void main(String[] args) {
        int[] number = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "hand";
        solution(number, hand);
    }

    static int[][] keypad = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2}
            , {1, 0}, {1, 1}, {1, 2}
            , {2, 0}, {2, 1}, {2, 2}
            , {3, 0}, {3, 2}
    };

    public static String solution(int[] numbers111, String hand) {
        String answer = "";


        /*
        leftPosition =
        rightPosition =
        keypad[keyNumber][x]
        keypad[keyNumber][x]
        */

        /*2,1 0,3
        1,2 1,2
        1+1 == 1+1*/
        //distance(4, 2);
        //distance(9, 2);

        int leftPos = 10, rightPos = 11;
        hand = "right";
        StringBuffer sb = new StringBuffer();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                leftPos = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                rightPos = numbers[i];
            } else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
                if (distance(leftPos, numbers[i]) == distance(rightPos, numbers[i])) {
                    if ("right".equals(hand)) {
                        sb.append("R");
                        rightPos = numbers[i];
                    } else {
                        sb.append("L");
                        leftPos = numbers[i];
                    }

                } else if (distance(leftPos, numbers[i]) < distance(rightPos, numbers[i])) {
                    sb.append("L");
                    leftPos = numbers[i];
                } else {
                    sb.append("R");
                    rightPos = numbers[i];
                }
            }
        }

        System.out.println(sb.toString());

        return answer;
    }

    public static int distance(int checkNumber, int tergetNumber) {
        System.out.println(Math.abs(keypad[checkNumber][0] - keypad[tergetNumber][0]) + Math.abs(keypad[checkNumber][1] - keypad[tergetNumber][1]));
        return Math.abs(keypad[checkNumber][0] - keypad[tergetNumber][0]) + Math.abs(keypad[checkNumber][1] - keypad[tergetNumber][1]);
    }
}
