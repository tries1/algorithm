package programmers;

public class Nation124 {
    public static void main(String[] args) {
        //3으로 나누어지면 n/3 -1 로 바꿔주고 4
        int n = 6;

        String temp;
        if(n % 3 == 0){

            //n = (n / 3 - 1) + 4;
            temp = Integer.toString(n, 3);
            System.out.println(temp);
            temp = temp.replace("0", "4");
            System.out.println(temp);
            //System.out.println(Integer.toString(n, 3));
        } else {
            System.out.println(Integer.toString(n, 3));
        }

/*
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(10));*/
    }
}
