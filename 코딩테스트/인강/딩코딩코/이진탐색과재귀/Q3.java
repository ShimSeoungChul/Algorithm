package 인강.딩코딩코.이진탐색과재귀;

import java.util.ArrayList;
import java.util.List;

// 더하거나 뺴거나
// https://fern-freeze-290.notion.site/2-aa9f6967b8604d3d9d609d0cc9ce0c9e#04fe52d2fc104b80b3c37c6c02e5888d
public class Q3 {
    public static void main(String[] args) {
        System.out.println(getCountOfWaysToTargetByDoingPlusOrMinus(new int[] {1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(getCountOfWaysToTargetByDoingPlusOrMinus2(new int[] {1, 1, 1, 1, 1}, 3)); // 5
    }

    // 내 풀이
    public static int getCountOfWaysToTargetByDoingPlusOrMinus(int[] numbers, int targetNumber) {
        List<Integer> sumList = new ArrayList<>();
        sumList.add(0);
        int count = 0;
        for (int number : numbers) {
            List<Integer> newSumList = new ArrayList<>();
            for (int sum : sumList) {
                newSumList.add(sum + number);
                newSumList.add(sum - number);
            }
            sumList = newSumList;
        }

        for (int sum : sumList) {
            if (sum == targetNumber) count++;
        }

        return count;
    }

    // 강사님 풀이
    public static int getCountOfWaysToTargetByDoingPlusOrMinus2(int[] numbers, int targetNumber) {
        List<Integer> sumList = new ArrayList<>();
        getAllWaysByDoingPlusOrMinus(numbers, 0, 0, sumList);

        int count = 0;
        for (int sum : sumList) {
            if (sum == targetNumber) count++;
        }

        return count;
    }

    public static void getAllWaysByDoingPlusOrMinus(int[] numbers, int currentIndex, int currentSum, List<Integer> sumList) {
        if (currentIndex == numbers.length -1) {
            sumList.add(currentSum + numbers[currentIndex]);
            sumList.add(currentSum - numbers[currentIndex]);
            return;
        }

        getAllWaysByDoingPlusOrMinus(numbers, currentIndex + 1, currentSum + numbers[currentIndex], sumList);
        getAllWaysByDoingPlusOrMinus(numbers, currentIndex + 1, currentSum - numbers[currentIndex], sumList);
    }
}

/*
getCountOfWaysToTargetByDoingPlusOrMinus 함수 내부에서 numbers의 특정 요소인 number 하나씩 반복하며,
list 자료형에 저장된 요든 요소에 -number, number를 각각 더하여 발행하는 값 들을 새로운 list 자료형을 생성하여 입력한다.
생성한 sumList에서  targetNumber가 몇 개인지 확인하고, 해당 값을 반환한다.

 @ 재귀 문제는 탈출 조건이 있어야함을 유의하자.
 */