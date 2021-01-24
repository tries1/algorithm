package programmers;

import java.util.ArrayList;
import java.util.List;

public class KakaoMaxExpression {

    public static class Symbols {
        public String symbol;
        public Integer priority;
        public Integer index;

        public Symbols(String symbol, Integer priority) {
            this.symbol = symbol;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        //문자열 받으면, 숫자와 문자를 구분해야함

        String expression = "100-200*300-500+20";

        String a = "-";

        int startIdx = 0, endIdx = 0;
        int num1 = 0, num2 = 0;
        String[] arr = expression.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(a)) {
                startIdx = i - 3;
                endIdx = i + 4;

                num1 = Integer.parseInt(expression.substring(startIdx, i));
                num2 = Integer.parseInt(expression.substring(i + 1, endIdx));
                System.out.println(num1);
                System.out.println(num2);

                System.out.println(expression);
                expression = expression.substring(0, startIdx) + (num1 - num2) + expression.substring(endIdx);
                System.out.println(expression);


            }
        }

        if (true) {
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        List<Symbols> symbols = new ArrayList<>();

        int startIdx1 = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (i == expression.length() - 1) {
                numbers.add(Integer.parseInt(expression.substring(startIdx)));
            } else if (Character.isDigit(expression.charAt(i))) {
                continue;
            } else {
                numbers.add(Integer.parseInt(expression.substring(startIdx, i)));
                symbols.add(new Symbols(expression.substring(i, i + 1), 0));

                startIdx = i + 1;
            }
        }

        numbers.forEach(System.out::println);
        System.out.println("----------");
        symbols.forEach(System.out::println);

        /*
        100-200*300-500+20
        = 100-(200*300)-500+20
        = 100-60000-(500+20)
        = (100-60000)-520
        = (-59900-520)
        = -60420
        */
/*
        * >+ > -
        * > - > +

        + > * >-
        + > - > *

        - > + > *
        - > * >+*/
        // 우선 순위설정

        List<Symbols> priorityList = setPriority(symbols, 2, 3, 1);
        System.out.println(calcurate(numbers, priorityList));

    }

    public static List<Symbols> setPriority(List<Symbols> list, int plus, int minus, int multi) {
        for (Symbols symbols : list) {
            if (symbols.symbol.equals("+")) {
                symbols.priority = plus;
            }

            if (symbols.symbol.equals("-")) {
                symbols.priority = minus;
            }

            if (symbols.symbol.equals("*")) {
                symbols.priority = multi;
            }
        }

        return list;
    }

    public static int calcurate(List<Integer> numbers, List<Symbols> symbols) {

        int sum = 0;
        int sumCount = 1;
        int idx = 0;
        int checkPriority = 1;
        while (sumCount != symbols.size()) {

            if (symbols.get(idx).priority == checkPriority) {

                System.out.println(idx + ", " + numbers.get(idx - 1) + ", " + numbers.get(idx + 1));

                if (symbols.get(idx).symbol.equals("*")) {
                    sum += numbers.get(idx) * numbers.get(idx + 1);
                }

                if (symbols.get(idx).symbol.equals("-")) {
                    sum += numbers.get(idx) - numbers.get(idx + 1);
                }

                if (symbols.get(idx).symbol.equals("+")) {
                    sum += numbers.get(idx) + numbers.get(idx + 1);
                }

                sumCount++;
            }

            if (idx == symbols.size() - 1) {
                idx = 0;
                checkPriority++;
            }

            idx++;
        }

        return sum;
    }
}
