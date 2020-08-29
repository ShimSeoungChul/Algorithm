class Interval{
    private int start;
    private int end;

    protected Interval(int s, int e){
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class MergeInterval {
    public static void main(String[] args){
        Interval in2 = new Interval(1,3);
        Interval in1 = new Interval(2,6);
        Interval in3 = new Interval(8,10);
        Interval in4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        MergeInterval mergeInterval = new MergeInterval();
        List<Interval> results = mergeInterval.merge(intervals);
        System.out.println("=====");
        mergeInterval.print(results);
    }

    private List<Interval> merge(List<Interval> intervals){
        List<Interval> results = new ArrayList<>();

        print(intervals); //Before sorting
        System.out.println("=====");
        //1. sorting
        //컬렌션을 이용한 sorting
        //Collections.sort(intervals, comp);

        //람다를 이용한 sorting
        Collections.sort(intervals, (a,b)-> a.getStart() - b.getStart());
        print(intervals); //After sorting


        //2. 중복되는 범위 합치기
        Interval before = intervals.get(0);  // 리스트의 첫 번째 요소 저장
        for(int i=1; i < intervals.size(); i++){
            Interval current = intervals.get(i);

            if(before.getEnd() >= current.getStart()){
                before.setEnd(Math.max(before.getEnd(),current.getEnd()));
            }else{
                results.add(before);
                before = current;
            }
        }

        //마지막 남은 before가 list에 저장되지 않았다면 결과에 추가로 저장
        if(!results.contains(before)){
            results.add(before);
        }

        return results;
    }

    private  void print(List<Interval> list){
        for(Interval interval : list){
            System.out.println(interval.getStart() + " " + interval.getEnd());
        }
    }

    Comparator<Interval> comp = new Comparator<>() {
        @Override
        public int compare(Interval in1, Interval in2) {
            return in1.getStart() - in2.getStart();
        }
    };
}

