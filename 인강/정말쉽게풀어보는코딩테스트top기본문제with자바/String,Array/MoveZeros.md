# MoveZeros 문제

## Problem
- 배열 num을 감안할 때 0이 아닌 요소의 상대적인 순서를 유지하면서 모든 0을 끝으로 이동시키는 함수를 작성하시오

## Example
- Input : [0,3,2,0,8,5]
- Output: [3,2,8,5,0,0]

## Solution
1. 0이 아닌 값을 array에 담는다.  <br />
2. Index를 기억한다. <br />
3.  해당 Index 부터 배열 마지막 원소 까지 0을 입력한다.<br />
