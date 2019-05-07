import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int a = 2;
        int b = 29;
        System.out.println(LocalDate.of(2016, a, b).getDayOfWeek().name().substring(0, 3));
        System.out.println("--------------------------------");

        String test = "a|s|d||d||s|A||";
        String test2 = " dasds dasdasda dsa ";
        System.out.println("+++++++++++> " + test2.trim() + " <+++++++++++");
        String[] tests = test.split("\\|\\|");

        System.out.println(tests.length);
        Arrays.stream(tests).forEach(System.out::println);
    }
}
