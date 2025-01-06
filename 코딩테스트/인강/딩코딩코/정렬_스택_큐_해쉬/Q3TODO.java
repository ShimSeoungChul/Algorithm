package 인강.딩코딩코.정렬_스택_큐_해쉬;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579
// 멜론 베스트 앨범 뽑기
// https://fern-freeze-290.notion.site/3-eda59f516d3d4372bdabe54674101396
public class Q3TODO {
    public static void main(String[] args) {
        System.out.println("정답 = [4, 1, 3, 0] / 현재 풀이 값 = " + Arrays.toString(getMelonBestAlbum(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        )));

        System.out.println("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = " + Arrays.toString(getMelonBestAlbum(
                new String[]{"hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"},
                new int[]{2000, 500, 600, 150, 800, 2500, 2000}
        )));
    }

    public static int[] getMelonBestAlbum(String[] genres, int[] plays) {
        Map<String, Integer> totalPlayMap = new HashMap<>();
        Map<String, List<Music>> indextPlayMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            Music music = new Music(i, play);

            if (totalPlayMap.containsKey(genre)) {
                totalPlayMap.put(genre, totalPlayMap.get(genre) + play);
                indextPlayMap.get(genre).add(music);
            } else {
                totalPlayMap.put(genre, play);
                indextPlayMap.put(genre, new ArrayList<>(List.of(music)));
            }
        }

        List<String> sotredGenres = totalPlayMap.entrySet().stream()
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String genre: sotredGenres) {
            List<Integer> sortedIndexList = indextPlayMap.get(genre).stream()
                    .sorted((m1, m2) -> Integer.compare(m2.play, m1.play))
                    .map(music -> music.index)
                    .collect(Collectors.toList());

            if (sortedIndexList.size() < 2) {
                result.addAll(sortedIndexList);
            } else {
                result.addAll(sortedIndexList.subList(0, 2));
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Music{
    int index;
    int play;

    public Music(int index, int play) {
        this.index = index;
        this.play = play;
    }
}

/*
장르별 노래 플레이 수를 저장하는 Map을 만든다. ex) classic - 1450, pop - 3100
장르별 노래 플레이 수 순위를 저장하는 리스트를 만든다. 위에서 만든 Map을 정렬하여 만든다. ex) classic, pop, jazz
장르별 노래의 인덱스와 플레이 수를 저장하는 Map을 만든다. ex) classic - 0-500, 2-150, 3-800 / pop - 1-?, 4-?
장르를 순회하며 재생 횟수가 높은 순서로 2개 곡을 결과에 포함한다. 재생 횟수가 같으면 고유 번호 순서대로 결과에 포함한다. 위에서 만든 Map을 정렬하여 만든다.
 */