package codinginterview.arrayandstring;

public class StringCompress {
    public static void main(String[] args) {
        //String s = "aabcccccaaa";
        //a2b1c5a3

        String s = "aaaaaaaaaaaaassjsssssddddwwwdieeeidddeorrqe";

        StringBuffer sb = new StringBuffer();
        String alphabet = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                count++;
                alphabet = String.valueOf(s.charAt(i));
                continue;
            }

            if (String.valueOf(s.charAt(i)).equals(alphabet)) {
                count++;
                alphabet = String.valueOf(s.charAt(i));
            } else {
                sb.append(alphabet + count);
                alphabet = String.valueOf(s.charAt(i));
                count = 1;
            }

            if (i == s.length() - 1) {
                sb.append(alphabet + count);
            }
        }

        System.out.println(sb.toString());
    }
}
