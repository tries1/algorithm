package hackerrank;

/**
 * 못풀었음..
 * 샘플코드대로 동작하도록 생각하다보니, 문제해결하지 못함
 *
 * 선택정렬로 풀이하면 된다.
 * 순서대로 정렬이 되어야하니, 1~N개가 순서대로 정렬되어 있지 않은 값이 있다면
 * 해당 값보다 작은수중 가장 작은수의 위치를 작아서 swap을 진행 */
public class MinimumSwaps2 {
    public static void main(String[] args) {
        //int[] arr = {7, 1, 3, 2, 4, 5, 6};
        int[] arr = {4, 3, 1, 2};

        int swap = 0, temp, idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if(arr[j] == i + 1){
                        idx = j;
                        break;
                    }
                }

                temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                swap++;
            }
        }

        System.out.println(swap);

    }
}
