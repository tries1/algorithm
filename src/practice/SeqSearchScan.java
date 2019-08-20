package practice;

public class SeqSearchScan {

    public static void main(String[] args) {
        int sentinel = 53;
        int[] arr = {1, 23, 41, 4, 352, 53, 24,  sentinel};
        int idx = seqSearchScan(arr, arr.length + 1, 53);
        System.out.println("값의 위치는 : " + idx);
    }

    public static int seqSearchScan(int[] a, int n, int key) {
        int i = 0;
        //a[n] = key;

        /*while (true) {
            if (a[i] == key) {
                break;
            }
            i++;
        }*/
        for (int item : a) {
            if (item == key) {
                break;
            }

            i++;
        }

        return i == n ? -1 : i;
    }
}
