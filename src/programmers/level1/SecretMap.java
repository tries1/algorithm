package programmers.level1;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        solution(n, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String temp = "";
        String[] b1, b2;
        for (int i = 0; i < n; i++) {
            b1 = lpad(Integer.toBinaryString(arr1[i]), n, "0").split("");
            b2 = lpad(Integer.toBinaryString(arr2[i]), n, "0").split("");

            for (int j = 0; j < b1.length; j++) {
                temp += (b1[j].equals("1") || b2[j].equals("1")) ? "#" : " ";
            }

            System.out.println(temp);
            answer[i] = temp;
            temp = "";
        }

        return answer;
    }

    private static String lpad(String originStr, int resultLength, String addChar) {
        StringBuilder sb = new StringBuilder();

        for (int i = originStr.length(); i < resultLength; i++) {
            sb.append(addChar);
        }

        return sb.toString() + originStr;
    }
}
