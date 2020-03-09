package codility;

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {
        //7
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(solution(H));

    }

    //배열 H의 각각의 값은 돌담의 높이를 나타낸다.
    //H가 주어졌을때 최소 필요한 블록의 수를 계산
    //이전높이가 현재랑 같다면 하나의 블록으로 계산이 가능(preHeight == curHeight)
    //이전 높이보다 현재높이가 커졌다면 stack에 push answer++;
    //이전 높이보다 현재높이가 낮아졌다면 stack에서 pop
    public static int solution(int[] H) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < H.length; i++) {
            //이전높이보다 현재높이가 낮을때
            while (!stack.isEmpty() && stack.peek() > H[i]){
                stack.pop();
            }

            //이전높이보다 현재높이가 클때
            if (stack.isEmpty() || stack.peek() < H[i]){
                stack.push(H[i]);
                answer++;
            }
        }

        return answer;

        //모번답안
        /*Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty() && stack.peek() > H[i]) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < H[i]) {
                stack.push(H[i]);
                count++;
                System.out.println(H[i]);
            }
        }
        return count;*/
    }
}
