package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

    제한사항
    genres[i]는 고유번호가 i인 노래의 장르입니다.
    plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
    genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    장르 종류는 100개 미만입니다.
    장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    모든 장르는 재생된 횟수가 다릅니다.

    입출력 예
    genres	plays	return
    [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

---------------------------------------------------------------------------------------
    입출력 예 설명
    classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

    고유 번호 3: 800회 재생
    고유 번호 0: 500회 재생
    고유 번호 2: 150회 재생
    pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

    고유 번호 4: 2,500회 재생
    고유 번호 1: 600회 재생
    따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
*/
public class BestAlbum {
    public static void main(String[] args) {
        //장르별 재생횟수 합 구하기 : 출력 순서
        //장르 개수 구하기 : 출력수 = 장르수 * 2
        //장르내 탑 2 구하기 : 출력값 2

        //[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500] = [4, 1, 3, 0]
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        /*String[] genres = {"classic", "pop", "classic", "classic", "pop", "rock", "troat", "rock", "ballard", "ballard"};
        int[] plays = {500, 600, 150, 800, 2500, 3000, 250, 7000, 100000, 100005};*/
        int[] answer = solution(genres, plays);


        Arrays.stream(answer).forEach(value -> System.out.print(value + ", "));
    }

    public static int[] solution(String[] genres, int[] plays) {
        AtomicInteger index = new AtomicInteger(0);
        List<Song> songs = Arrays.stream(genres.clone()).map(s -> new Song(index.get(), s, plays[index.getAndIncrement()])).collect(Collectors.toList());
        Map<String, Integer> genresPlayCount = songs.stream().collect(Collectors.groupingBy(Song::getGenre, Collectors.summingInt(Song::getPlayCount)));
        List<String> genreList = genresPlayCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(Map.Entry::getKey).collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        Function<String, List<Song>> songsByGenreOrderByPlayCountDescTop2 = (genre) -> songs.stream().filter(song -> song.getGenre().equalsIgnoreCase(genre)).sorted(Comparator.comparing(Song::getPlayCount).reversed()).limit(2).collect(Collectors.toList());
        genreList.forEach(genre -> songsByGenreOrderByPlayCountDescTop2.apply(genre).forEach(song -> answer.add(song.getId())));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class Song{
        private int id;
        private String genre;
        private int playCount;

        public Song(int id, String genre, int playCount){
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public String toString(){
            return String.format("id: %s, genre: %s, playCount: %s", this.id, this.genre, this.playCount);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }
    }
}
