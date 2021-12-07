import java.util.Arrays;
import java.util.stream.IntStream;

public class SequentialSerach {
    public static void main(String[] args){
        String[] strings = {"a","b","c","d","e"};
        String target = "d";
        for(int i=0; i< strings.length; i++)
            if(strings[i].equals(target))
                System.out.println("탐색 중인 인덱스 위치는 "+i+"입니다.");
    }
}
