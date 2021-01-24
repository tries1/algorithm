package test;

public class Test3 {
    public static void main(String[] args) {

        int n = 78;

        int check = n + 1;
        long checkBinaryCount;
        long nBinaryCount = Integer.toBinaryString(n).replace("0", "").length();

        while (true) {
            checkBinaryCount = Integer.toBinaryString(check).replace("0", "").length();

            if (nBinaryCount == checkBinaryCount) {
                break;
            }
            check++;
        }

        System.out.println(check);
    }
}
