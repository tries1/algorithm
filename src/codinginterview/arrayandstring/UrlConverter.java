package codinginterview.arrayandstring;

public class UrlConverter {
    public static void main(String[] args) {
        String s = "Mr John Smith";

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(' ' == s.charAt(i)){
                sb.append("%20");
                continue;
            }

            sb.append(s.charAt(i));
        }

        //System.out.println(s.replace(" ", "%20"));
        System.out.println(sb.toString());
    }
}
