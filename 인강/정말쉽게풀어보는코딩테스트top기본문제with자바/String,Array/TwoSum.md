# TwoSum 문제

## Problem
- 기본 문제는 Example만 보고 풀 수 있어야함

## Example
- Input : int[] nums = {2,8,10,21};
          int target = 10;
- Output: int[] = {1,2}

## Solution
- 문제 정확히 이해하기 <br />
- 알고리즘 정하고 담을 그릇 정하기 <br />
1. 생각 -> 프로그램 (한국어 -> Java)
2. Map(nums )과 Array를 사용한다 <br />
3. index 0 부터 for문으로 반복하여, target에서 각 nums 요소의 값을 뺀 값을 key로, <br />
해당 nums 요소의 인덱스를 value로 저장한다. ex) 첫 번째 반복 10 - 2 =8, 0 Map (8,0) 저장 
4. if문을 통해 4번에서 Map에 저장한 key값과 동일한 배열 요소가 나오면 반복문을 종료하고, <br />
현재 nums 요소의 인덱스와 Map에 저장된 value 값에 각각 1을 더해 return 한다.<br />
