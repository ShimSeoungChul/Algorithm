import java.util.Scanner;

/*
입력
a1

출력
2
 */
public class 왕실의나이트 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        int row = location.charAt(1) - 48; // 행 위치, 문자 - 48
        int col = location.charAt(0) - 96; // 열 위치, 문자 - 96

        // 이동 할 수 있는 경우
        String[][] moves = {{"r","r","u"},{"r","r","d"},{"l","l","u"},{"l","l","d"},
                        {"u","u","l"},{"u","u","r"},{"d","d","l"},{"d","d","r"}}; // r: 오른쪽, l: 왼쪽, u:위쪽, d:아래쪽

        int count = 0; // 이동 가능한 경우의 수
        for(String[] moveArr: moves){
            // 나이트 초기 위치 입력
            int x = col;
            int y = row;

            // 나이트 이동
            for(String move: moveArr){
                if(move.equals("r")){
                   x++;
                }else if(move.equals("l")){
                   x--;
                }else if(move.equals("u")){
                   y--;
                }else if(move.equals("d")){
                   y++;
                }
            }

            // 이동 가능한 경로인지 확인
            if(y<=8 && y>=1 && x<=8 && x>=1){
                count++;
            }
        }

        System.out.println(count);
    }
}
