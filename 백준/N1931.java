
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNum = scanner.nextInt(); //사용할 수 있는 회의의 최대 개수


        //회의 정보 입력 meetings 변수에 입력
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < maxNum; i++) {
            Meeting meeting = new Meeting(scanner.nextInt(), scanner.nextInt());
            meetings.add(meeting);
        }

        // 종료 시간이 같(3, 3), (2, 3)(1, 3)의 시간 예약이 되어있을 경우
        // (1, 3)이 선택되어야 하므로 시작 시간 순으로 먼저 정렬합니다.
        meetings.sort((Meeting m1, Meeting m2) -> m1.getStart() - m2.getStart());
        //회읜 정보를 종료 시간이 빠른 순으로 정렬
        meetings.sort((Meeting m1, Meeting m2) -> m1.getEnd() - m2.getEnd());
        List<Meeting> results = new ArrayList<Meeting>();
        results.add(meetings.get(0));//첫 번째 회의는 무조건 포함
        meetings.remove(0);

        Meeting before = new Meeting(0, 0);
        before.setStart(results.get(0).getStart());
        before.setEnd(results.get(0).getEnd());
        for (Meeting next : meetings) {
            if (before.getEnd() <= next.getStart()) {
                results.add(next);
                before.setStart(next.getStart());
                before.setEnd(next.getEnd());
            }
        }
        System.out.println(results.size());
    }
}

class Meeting{
    private int start;
    private int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }
    public int getStart() {
        return start;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public void setStart(int start) {
        this.start = start;
    }
}


