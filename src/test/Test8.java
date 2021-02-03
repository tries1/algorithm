package test;

import java.util.ArrayList;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};


        List<Integer> result = new ArrayList<>();
        int lastDeployIndex = 0;
        int standByDeployCount = 0;
        for (int i = 0; i < progresses.length; i++) {
            for (int j = 0; j < progresses[j]; j++) {
                progresses[j] += speeds[j];

                if (progresses[j] >= 100) {
                    //re
                }
            }
        }
    }
}
