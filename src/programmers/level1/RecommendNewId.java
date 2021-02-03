package programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RecommendNewId {
    public static void main(String[] args) {
        //String newId = "...!@BaT#*..y.abcdefghijklm";
        //String newId = "z-+.^.";
        String newId = "abcdefghijklmn.p";
        System.out.println(solution(newId));
    }

    public static String solution(String new_id) {
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String id = Arrays.stream(new_id.split(""))
        .map(s -> ((Character.isUpperCase(s.charAt(0)))) ? s.toLowerCase() : s)
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        .map(s -> {
            if (!Character.isLowerCase(s.charAt(0)) && !Character.isDigit(s.charAt(0))
                    && !".".equals(s) && !"_".equals(s) && !"-".equals(s)) {
                return "";
            }

            return s;
        })
        .collect(Collectors.joining());

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String[] idArr = id.split("");
        String prev = "";
        for (int i = 0; i < idArr.length; i++) {
            if(".".equals(idArr[i]) && prev.equals(idArr[i])){
                idArr[i] = "";
                continue;
            }

            prev = idArr[i];
        }

        id = Arrays.stream(idArr).collect(Collectors.joining());
        idArr = id.split("");

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(idArr[0].equals(".")){
           idArr[0] = "";
        }

        if(idArr[id.length()-1].equals(".")){
           idArr[id.length()-1] = "";
        }

        id = Arrays.stream(idArr).collect(Collectors.joining());

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        id = ("".equals(id)) ? "a" : id;

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        id = id.substring(0, Math.min(id.length(), 15));
        id = (".".equals(id.substring(id.length() - 1))) ? id.substring(0, id.length() - 1) : id;
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        id = (id.length() <= 2) ? rpad(id, 3, id.substring(id.length() - 1)) : id;

        return id;
    }

    private static String rpad(String originStr, int resultLength, String addChar) {
        StringBuilder sb = new StringBuilder();

        for (int i = originStr.length(); i < resultLength; i++) {
            sb.append(addChar);
        }

        return originStr + sb.toString();
    }
}
