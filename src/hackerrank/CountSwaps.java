package hackerrank;

public class CountSwaps {
    public static void main(String[] args) {
        //3 2 1
        //int[] a = {3, 2, 1};
        int[] a = {1, 2, 3};
        countSwaps(a);
    }

    public static void countSwaps(int[] a) {
        int answer = 0;
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    answer++;
                }
            }

        }

        System.out.println("Array is sorted in " + answer + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}
