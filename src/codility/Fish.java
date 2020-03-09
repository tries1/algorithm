package codility;

import java.util.Stack;

public class Fish {

    public static void main(String[] args) {
        //2
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        //2
        //int[] A = {0, 1};
        //int[] B = {1, 1};

        System.out.println(solution(A, B));

    }

    //A배열은 물고기의 크기, B배열은 물고기의 진행방향
    //시간은 동일하게 흐르고 이미 지나간 물고기는 잡아먹지 못한다.
    //큰 물고기가 작은 물고기를 잡아먹고, 가장 마지막에 남은 물고이의 수를 리턴
    //0다운 1업
    //처음이 1이면 등록
    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int bigFish;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1){
                stack.push(A[i]);
            } else {

                while (!stack.isEmpty()){
                    bigFish = stack.peek();
                    if(bigFish > A[i]){
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if (stack.isEmpty()){
                    answer++;
                }
            }
        }

        return answer + stack.size();
    }
}
