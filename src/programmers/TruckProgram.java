package programmers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 * <p>
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 * <p>
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 * <p>
 * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한 조건
 * bridge_length는 1 이상 10,000 이하입니다.
 * weight는 1 이상 10,000 이하입니다.
 * truck_weights의 길이는 1 이상 10,000 이하입니다.
 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
 * 입출력 예
 * bridge_length	weight	truck_weights	return
 * 2	10	[7,4,5,6]	8
 * 100	100	[10]	101
 * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
 * 출처
 */

public class TruckProgram {

    public static void main(String[] args) {

        int[] truck_weights = {7, 4, 5, 6};

        //8
        //System.out.println(solution(2, 10, truck_weights));

        int[] truck_weights2 = {10};

        //101
        //System.out.println(solution(100, 100, truck_weights2));
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(solution(100, 100, truck_weights3));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowBridgeSize;
        LinkedList<Truck> bridge = new LinkedList<>();
        Queue<Truck> waitTrucks = new LinkedList<>();
        Arrays.stream(truck_weights).boxed().forEach(it -> waitTrucks.offer(new Truck(it, 0)));
        Truck currentTruck;

        while (!waitTrucks.isEmpty() || !bridge.isEmpty()) {
            answer++;

            //다리위 트럭 이동
            bridge.stream().forEach(truck -> truck.location++);

            Iterator<Truck> iter = bridge.iterator();
            while (iter.hasNext()) {
                Truck current = iter.next();
                if (current.location == bridge_length + 1) {
                    iter.remove();
                }
            }

            currentTruck = waitTrucks.peek();
            if (currentTruck != null) {
                nowBridgeSize = bridge.stream().map(truck -> truck.weight).reduce((truck1, truck2) -> truck1 + truck2).orElse(0);

                //다리에 들어갈수 있다
                if (weight >= nowBridgeSize + currentTruck.weight) {
                    currentTruck = waitTrucks.poll();
                    currentTruck.location = 1;
                    bridge.offer(currentTruck);
                }
            }
        }

        return answer;
    }

    public static class Truck {
        public int weight;
        public int location;

        public Truck(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }
    }
}
















