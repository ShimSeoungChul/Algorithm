
/*
입력 예시
3 3
1 2
1 3
2 3
 */

import java.util.Scanner;
import java.util.stream.IntStream;

// 서로소 집합을 활용한 사이클 판별 소스코드
public class UnionFindCycleDetetion {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        //노드의 개수와 간선(union 연산)의 개수 입력받기
        int v = sc.nextInt();
        int e = sc.nextInt();

        //부모테이블을 생성하고, 부모를 자기 자신으로 초기화
        int []parent = new int[v+1];
        IntStream.range(1,v+1).forEach(i->parent[i]=i);

        boolean cycle = false; //사이클 발생 여부
        UnionFindCycleDetetion algorithm = new UnionFindCycleDetetion();

        for(int i=1; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //사이클이 발생한 경우 종료
            if (algorithm.findParent(parent, a) == algorithm.findParent(parent, b)){
                cycle = true;
                break;
            }else { //사이클이 발생하지 않았다면 합집합(union) 수행
                algorithm.unionParent(parent, a, b);
            }
        }

        if (cycle) System.out.println("사이클이 발생했습니다.");
        else System.out.println("사이클이 발생하지 않았습니다.");

    }

    //특정 원소가 속한 집합을 찾기
    private int findParent(int[] parent, int x){
        //루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if(parent[x] != x)
            parent[x] = findParent(parent, parent[x]);
        return parent[x];
    }

    //두 원소가 속한 집합을 합치기
    private void unionParent(int[] parent, int a, int b){
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
