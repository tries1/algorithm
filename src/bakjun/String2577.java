package bakjun;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class String2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int total = A * B * C;
        String s = String.valueOf(total);

        Map<Integer, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(key -> Integer.parseInt(key), Collectors.counting()));

        for (int i = 0; i < 10; i++) {
            System.out.println(Optional.ofNullable(map.get(i)).orElse(0L));
        }
    }
}
