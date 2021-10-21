import java.util.Scanner;
import java.util.stream.IntStream;

/*
입력 예시
6 4
1 4
2 3
2 4
5 6
 */
public class 서로소집합알고리즘 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //노드의 개수와 간선(union 연산)의 개수 입력받기
        int v = sc.nextInt();
        int e = sc.nextInt();

        //부모테이블을 생성하고, 부모를 자기 자신으로 초기화
        int []parent = new int[v+1];
        IntStream.range(1,v+1).forEach(i->parent[i]=i);

        서로소집합알고리즘 disjointset = new 서로소집합알고리즘();

        //union 연산을 각각 수행
        for(int i=1; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            disjointset.unionParent(parent,a,b);
        }

        //각 원소가 속한 집합 출력
        System.out.print("각 원소가 속한 집한: ");
        for(int i=1; i<=v; i++)
            System.out.print(disjointset.findParent(parent, i) + " ");
        System.out.println();

        //부모 테이블 내용 출력
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++)
            System.out.print(parent[i] + " ");
    }

    //특정 원소가 속한 집합 찾기
    private int findParent(int[] parent, int x){
        //루트 노드가 아니라면, 루트 노드를 찾을 떄까지 재귀적으로 호출
        if(parent[x] != x) return findParent(parent, parent[x]);
        return x;
    }

    //두 원소가 속한 집합 합치기
    private void unionParent(int[] parent, int a, int b){
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
