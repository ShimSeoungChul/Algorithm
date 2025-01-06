package 인강.딩코딩코.트리와힙_BFS와DFS_그리고DP;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://fern-freeze-290.notion.site/4-BFS-DFS-DP-c6dbc3bd7d0042dea24e022d9a2df3eb
public class 농심라면공장TODO {
    public static void main(String[] args) {
        int ramenStock = 4;
        int[] supplyDates = {4, 10, 15};
        int[] supplySupplies = {20, 5, 10};
        int supplyRecoverK = 30;

        System.out.println(getMinimumCountOfOverseasSupply(ramenStock, supplyDates, supplySupplies, supplyRecoverK));
        System.out.println("정답 = 2 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println("정답 = 4 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(2, new int[]{1, 10}, new int[]{10, 100}, 11));
        System.out.println("정답 = 2 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(2, new int[]{0, 10, 15}, new int[]{20, 10, 15}, 35));
        System.out.println("정답 = 3 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(2, new int[]{0, 20, 25}, new int[]{20, 10, 15}, 35));

        System.out.println("정답 = 2 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply2(2, new int[]{0, 10, 15}, new int[]{20, 10, 15}, 35));
        System.out.println("정답 = 3 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply2(2, new int[]{0, 20, 25}, new int[]{20, 10, 15}, 35));

    }

    // 내 풀이
    public static int getMinimumCountOfOverseasSupply(int stock, int[] dates, int[] supplies, int k) {
        int supplyCount = 0;
        PriorityQueue<Integer> supplyQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // 다음 밀가루 공급일까지 재고가 부족하면 밀가루를 가져온다.
        for (int i = 0; i < dates.length; i++) {
            int nextDate = i == dates.length -1? k : dates[i+1];
            if (nextDate > stock) {
                stock += supplies[i];
                supplyCount++;
            } else {
                supplyQueue.add(supplies[i]);
            }
        }

        // 밀가루가 정상적으로 들어오는 날짜까지 재고가 부족하면 밀가루를 가져온다.
        while (!supplyQueue.isEmpty()) {
            if (k > stock) {
                stock += supplyQueue.poll();
                supplyCount++;
            } else {
                break;
            }
        }

        return supplyCount;
    }

    // 강사님 풀이
    public static int getMinimumCountOfOverseasSupply2(int stock, int[] dates, int[] supplies, int k) {
        int supplyCount = 0;
        PriorityQueue<Integer> supplyQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int lastAddedDateIndex = 0;
        while (stock <= k) {
            while (lastAddedDateIndex < dates.length && dates[lastAddedDateIndex] <= stock) {
                supplyQueue.add(supplies[lastAddedDateIndex]);
                lastAddedDateIndex += 1;
            }

            if (!supplyQueue.isEmpty()) {
                stock += supplyQueue.poll();
                supplyCount++;
            }
        }

        return supplyCount;
    }

    }
// 날짜를 순회하며 밀가루를 가져올지 선택한다. 최대한 가져오는 횟수를 적게한다.
// 다음 밀가루 공급일까지 버틸수 있는지 확인한 후, 밀가루를 가져올지 말지 선택한다.
// 밀가루가 정상적으로 들어오는 날짜지 버틸 재고가 부족하면, 위에서 가져오지 않은 밀가루 중 큰 순서대로 가져온다.
