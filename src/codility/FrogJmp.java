package codility;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }


    public static int solution(int X, int Y, int D) {
        //X는 현재위치
        //Y는 도착하고싶은 곳
        //D는 한번에 점프할수 있는 거리

        //85 - 10 = 75
        //75 / 30 =

        return (int) Math.ceil((double) (Y - X) / D);
    }
}
