package practice;

public class ReverseString {
    public static void main(String[] args) {
        //eno elttil ,sreyarp ruoy yaS
        String s = "Say your prayers, little one";

        String[] arr = s.split("");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
