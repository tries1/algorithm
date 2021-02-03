package programmers.level1;

import java.util.Stack;

public class KraneDollPick {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println("board.length : " + board.length);

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        int craneIndex = 0;
        int move;
        for (int i = 0; i < moves.length; i++) {
            move = moves[i] - 1;

            while (board[craneIndex][move] == 0 && craneIndex < board.length - 1) {
                craneIndex++;
            }
            System.out.println("move : " + (move) + ", craneIndex : " + craneIndex + " = " + board[craneIndex][move]);

            if (board[craneIndex][move] != 0) {
                basket.push(board[craneIndex][move]);
                board[craneIndex][move] = 0;
            }

            if (checkBasketRemove(basket)) {
                answer += 2;
            }

            craneIndex = 0;
        }

        return answer;
    }

    public static boolean checkBasketRemove(Stack<Integer> basket) {
        if (basket.size() <= 1) {
            return false;
        }

        Integer top1 = basket.pop();
        Integer top2 = basket.pop();

        if (!top1.equals(top2)) {
            basket.push(top2);
            basket.push(top1);
            return false;
        }

        return true;
    }
}
