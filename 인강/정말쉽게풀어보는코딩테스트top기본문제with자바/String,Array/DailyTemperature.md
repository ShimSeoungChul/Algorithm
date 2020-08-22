## Problem
```
 int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
 Output:       1   1    4  2   1   1   0    0
```
- nums는 각 날의 온도이다. output은 해당 날 부터 몇 일 후 온도가 올라가는 지 보여준다.

## Solution
- 스택을 이용한다
- for문을 통해 nums 배열의 인덱스를 차례로 stack 에 저장한다
- stack에 저장된 가장 최근(stack.peek()) 값을 인덱스로 하는 위치의 nums 요소 값과  반복문 i 위치의 nums 요소 값을 비교한다.
- nums[stack.peek()] 값 보다 nums[i]가 크면 stack.pop() 메소드를 실행해 stack의 값을 빼서 results 배열에 집어 넣는다. <br>
그리고 nums[stack.peek()] 값 보다 nums[i]가 작거나 stack이 다 비워질 때까지 이 행위를 반복한다.
- 만약 nums[i]가 nums[stack.peek()]  보다 작으면 for문의 다음 반복 순서로 넘어간다. 

