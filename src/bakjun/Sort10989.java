package bakjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sort10989 {
    public static void main(String[] args) throws IOException {
        try (
                InputStreamReader reader = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(reader);
                OutputStreamWriter writer = new OutputStreamWriter(System.out);
                BufferedWriter bw = new BufferedWriter(writer)
        ) {
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[10000];
            for (int i = 0; i < N; i++) {
                A[Integer.parseInt(br.readLine()) - 1]++;
            }

            for (int i = 0; i < 10000; i++) {
                for (int j = 0; j < A[i]; j++) {
                    bw.write(i + 1);
                }
            }

            System.out.println(bw.toString());
        }
    }
}