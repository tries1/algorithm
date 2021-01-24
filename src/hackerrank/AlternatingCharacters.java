package hackerrank;

/**
 * 현재문자의 다음 문자가 같을때, 삭제하고 삭제횟수를 출력
 * 다음 문자가 같지 않으면 break;
 * 같다면 삭제시키고, 다음에 비교할 index로 이동
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
        /*
        AAAA => 3
        BBBBB => 4
        ABABABAB => 0
        BABABA => 0
        AAABBB => 4
        */

        String a = "AAABBB";


        int count = 0;
        String[] arr = a.split("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equalsIgnoreCase(arr[j])) {
                    count++;
                    i = j;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
