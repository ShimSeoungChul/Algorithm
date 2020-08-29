
public class NumberOfIsland_DFS {
    public static void main(String[] argv){
        char[][] grid = {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'}
                };
        NumberOfIsland_DFS a = new NumberOfIsland_DFS();
        int count = a.solve(grid);
        System.out.println(count);
    }
    private int solve(char[][] grid){
        print(grid);

        //1. Error managing
        if(grid == null || grid.length == 0 || grid[0].length==0)
            return 0;

        //2. 00위치가 1인 것부터 찾는다
        int count = 0;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                if(grid[i][j]=='1'){
                    System.out.print("result count grid["+i+"]"+"["+j+"] ");
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        System.out.println("\n===after===");
        print(grid);
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i >= m || j <0 || j >= n || grid[i][j] != '1' ) return;

        //이미 방문한 데이터는 재방문 하지 않기 위해서
        //처음 기준점과 그 기준점 상하좌우에 있는 데이터를 X로 치환한다.
        grid[i][j]='x';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }

    private void print(char[][] grid){
        for(char[] i : grid) {
            for (char j : i)
                System.out.print(j+" ");
            System.out.println();
        }
    }
}

