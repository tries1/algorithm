package codility;

import java.util.Arrays;

public class GenomicRangeQuery {

    public static void main(String[] args) {
        //A = 1, C = 2, G = 3, T = 4
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        //{2, 4, 1}
        Arrays.stream(solution(S, P, Q)).forEach(i -> System.out.print(i + " "));
    }
    /*
    N is an integer within the range [1..100,000];
    M is an integer within the range [1..50,000];
    each element of arrays P, Q is an integer within the range [0..N − 1];
    P[K] ≤ Q[K], where 0 ≤ K < M;
    string S consists only of upper-case English letters A, C, G, T.
    */

    //P와 Q사이를 반복하면서
    //최소 뉴클레오티드를 찾으면 된다.
    //각각의 최소 뉴틀레오티드를 담은 배열을 리턴한다.

    //예상 풀이 방법
    //변수 S에 DNA시퀀스가 담겨있는데 배열이 아닌 String이다.
    //S를 반복하면서 해당하는 DNA를 숫자로 변환하고
    // P ~ Q사이에 해당하는 최소값을 찾아서 return array에 담아보자
    public static int[] solution(String S, int[] P, int[] Q) {
        String[] part = new String[P.length];
        int[] answer = new int[P.length];
        for (int i = 0; i < part.length; i++) {
            part[i] = S.substring(P[i], Q[i] + 1);

            if (part[i].indexOf("A") != -1) {
                answer[i] = 1;
            } else if (part[i].indexOf("C") != -1) {
                answer[i] = 2;
            } else if (part[i].indexOf("G") != -1) {
                answer[i] = 3;
            } else if (part[i].indexOf("T") != -1) {
                answer[i] = 4;
            } else {
                answer[i] = 4;
            }
        }

        return answer;


        //1차 답안
        /*String[] dna = Arrays.stream(S.split("")).toArray(String[]::new);
        Map<String, Integer> dnaMap = new HashMap<String, Integer>() {
            {
                put("A", 1);
                put("C", 2);
                put("G", 3);
                put("T", 4);
            }
        };

        List<Integer> answer = new ArrayList<>();
        int minimal;
        for (int i = 0; i < P.length; i++) {
            minimal = dnaMap.get("T");
            for (int j = P[i]; j <= Q[i]; j++) {
                if(minimal > dnaMap.get(dna[j])){
                    minimal = dnaMap.get(dna[j]);
                }

                if(minimal == 1){
                    break;
                }
            }

            answer.add(minimal);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();*/
    }
}
