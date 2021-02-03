package programmers.level1;

import java.util.Arrays;

public class Average {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4};

        Arrays.stream(arr).average().orElse(0);
    }
}
