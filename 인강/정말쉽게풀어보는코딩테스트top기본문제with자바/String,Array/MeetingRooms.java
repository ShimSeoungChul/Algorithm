
import java.util.Arrays;
import java.util.Comparator;

class Interval{
    private int start;
    private int end;

    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }
}

public class MeetingRooms {
    public static void main(String[] args){
        MeetingRooms a = new MeetingRooms();

        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve(intervals));

    }

    private boolean solve(Interval[] intervals){
        // 1 소팅
        if (intervals == null)
            return false;
        Arrays.sort(intervals,comparator);
        print(intervals);

        // 2 hold.end > cur.start
        for(int i=0; i< intervals.length ; i++){
            if(intervals[i].getEnd() > intervals[i].getStart())
                return false;
        }

        return true;
    }

    Comparator<Interval> comparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.getStart() - o2.getStart();
        }
    };

    private void print(Interval[] intervals){
        for(Interval interval : intervals){
            System.out.println(interval.getStart() + " " + interval.getEnd());
        }
    }

}


