package 인강.딩코딩코.트리와힙_BFS와DFS_그리고DP;

import java.util.*;

// https://fern-freeze-290.notion.site/4-BFS-DFS-DP-c6dbc3bd7d0042dea24e022d9a2df3eb
public class CGV극장좌석자리구하기 {
    public static void main(String[] args) {
        int seatCount = 9;
        int[] vipSeatArray = {4, 7};
        System.out.println(getAllWaysOfTheaterSeat(seatCount, vipSeatArray)); // 12
    }

    public static int getAllWaysOfTheaterSeat(int totalCount, int[] fixedSeatArray) {
        Map<Integer, Integer> dp = new HashMap();
        Set<Integer> fixedSeatSet = new HashSet<>(Arrays.stream(fixedSeatArray).boxed().toList());

        int lastFixedSeat = 0;
        for (int i = 0; i <= totalCount; i++) {
            if (i == 0 || i == 1){
                dp.put(i, 1);
                continue;
            }

            if (fixedSeatSet.contains(i)) {
                lastFixedSeat = i;
                int value = dp.get(i-1);
                dp.put(i, value);
                dp.put(++i, value);
                continue;
            }

            if (lastFixedSeat > 0){
                int value = dp.get(lastFixedSeat) * dp.get(i - lastFixedSeat);
                dp.put(i, value);
            } else {
                dp.put(i, dp.get(i-2) + dp.get(i-1));
            }
        }

        return dp.get(totalCount);
    }
}
/*
1
1
2
3
5
8
13
21
34

0  1
1  1
2  2
3  3
4  3
5  3
6  6
7  6
8  6
9  12

 */

/*
1
1 2 / 2 1
1 2 3 / 1 3 2 / 2 1 3
1 2 3 4 / 1 3 2 4 / 1 2 4 3 / 2 1 3 4 / 2 1 4 3
1 2 3 4 5 / 1 2 3 5 4 / 1 2 4 3 5 / 1 3 2 4 5 / 1 3 2 5 4 / 2 1 3 4 5 / 2 1 3 5 4 / 2 1 4 3 5

f(n) = f(n-2) + f(n-1) 형식으로 가짓수가 많아진다.
n이 fixedSeatArray인 경우 f(n), f(n+1)은 f(n-1)과 같다. 그리고 f(n+2)은 f(n) * f(m)이된다. m은 n - fixedSeat이다.
 */

