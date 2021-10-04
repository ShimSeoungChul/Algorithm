import java.util.Arrays;
import java.util.List;

public class SortedDemo {
    public static void main(String[] args){
        List<Vegetable> vegetables = Arrays.asList(
                new Vegetable("broccoli",0.3),
                new Vegetable("tomato",0.2),
                new Vegetable("eggplant",0.5)
        );

        //정렬
        vegetables.stream().sorted((a,b) -> {
            return a.kg.compareTo(b.kg);
        }).forEach(v -> System.out.println(v.name + ":" + v.kg));
    }

    static class Vegetable{
        private String name;
        private Double kg;

        Vegetable(String name, double kg){
            this.name = name;
            this.kg = kg;
        }
    }
}
