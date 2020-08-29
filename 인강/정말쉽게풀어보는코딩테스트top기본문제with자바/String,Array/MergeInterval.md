## Problem
- Given a Collection of intervals, merge all overlapping intervals

## Example
- Input: [[1,3],[2,6],[8,10],[15,18]]
- Output: [[1,6],[8,10],[15,18]]

<img width="551" alt="MergeInterval" src="https://user-images.githubusercontent.com/40673012/91632343-1248d100-ea1b-11ea-8eff-e7a31f53de1a.png">


## Solution
- 주어진 컬렉션을 오름차순으로 sorting
- 중복되는 범위 합치기
- 마지막 남은 범위 추가 처리
