package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

public class Truck {

    public static void main(String[] args) {

        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(2, 10, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        Arrays.stream(truck_weights).boxed().forEach(trucks::offer);
        IntStream.rangeClosed(1, bridge_length).forEach(value -> bridge.offer(0));
        int currentBridgeWeight = 0, truckWeight = trucks.poll();

        while (!trucks.isEmpty() && !bridge.isEmpty()){

            int outTruck = bridge.poll();
            if(outTruck != 0){
                currentBridgeWeight -= truckWeight;
                truckWeight = trucks.poll();

                if(bridge.size() == 0){
                   IntStream.rangeClosed(1, bridge_length - 1).forEach(value -> bridge.offer(0));
                }
            }

            if((truckWeight + currentBridgeWeight) <= weight){
                currentBridgeWeight += truckWeight;

                bridge.offer(truckWeight);

                /*if(bridge.size() < bridge_length){
                    IntStream.rangeClosed(1, bridge_length - bridge.size()).forEach(value -> bridge.offer(0));
                }*/
            }

            answer++;
        }

        return answer;
    }

    /*static int nowBridgeWeight = 0;
    static int bridgeLength, bridgeWeight, passingCount = 0, waitingCount = 0;
    static Queue<Integer> waitingTruck = new LinkedList<>();
    static Queue<Integer> passingTruck = new LinkedList<>();
    static Queue<Integer> passedTruck = new LinkedList<>();

    public static void main(String[] args) {

        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(2, 10, truck_weights));
    }

    // 경과 시간
    // 다리를 지난 트럭
    // 다리를 건너는 트럭
    // 대기 트럭
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int timeCount = 0;
        bridgeWeight = weight;
        bridgeLength = bridge_length;

        // add waiting
        Arrays.stream(truck_weights).forEach(value -> {
            waitingCount++;
            waitingTruck.offer(value);
        });

        // 1초에 1만큼씩 이동할수있으며 - while문으로 시간을 1씩 증가하고, passing트럭과 대기중이 트럭이 없는지확인
        // 순서대로 지나야하면, 이떄 weight를 체크해서 다음 트럭이 이동할수 있는지 확인필요

        while (bridgeLength > passingCount) {
            if(bridgeLength > passingCount){
                Integer truck = waitingTruck.poll();
                if (isCanInTheBridge(truck)) {
                    inTheBridge(truck);
                }
            }



            timeCount++;
        }

        return timeCount;
    }

    public static void inTheBridge(int nextTruckWeight) {
        passingTruck.offer(nextTruckWeight);
        nowBridgeWeight += nextTruckWeight;
        passingCount++;
    }

    public static void outBridge(int nextTruckWeight) {
        passedTruck.offer(passingTruck.poll());
        nowBridgeWeight -= nextTruckWeight;
        passingCount--;
    }

    public static void moveTheBridge() {


    }

    public static boolean isCanInTheBridge(int nextTruckWeight) {
        return (nowBridgeWeight + nextTruckWeight) < bridgeWeight;
    }

    public static boolean isFullBridge(int nextTruckWeight) {
        return (nowBridgeWeight + nextTruckWeight) < bridgeWeight;
    }*/
}
















