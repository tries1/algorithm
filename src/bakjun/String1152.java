package bakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class String1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Arrays.stream(br.readLine().trim().split(" "))
                .filter(s1 -> !s1.isEmpty())
                .collect(Collectors.toList())
                .size());
    }
}
