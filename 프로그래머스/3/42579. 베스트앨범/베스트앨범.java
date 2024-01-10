import java.util.*;
class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        int genreCount = 0;
        List<Genre> genreList = new ArrayList<>(100);
        List<Music> musicList = new ArrayList<>(200);
        HashMap<String, Integer> genreMapping = new HashMap();

        // 1. 장르 별 순위 구하기
        for(int i=0; i<genres.length; i++){
            musicList.add( new Music(genres[i], i, plays[i]));
            if(!genreMapping.containsKey(genres[i])){
                genreMapping.put(genres[i], genreCount);
                genreList.add(new Genre(genres[i], 0));
                genreCount++;
            }
            genreList.get(genreMapping.get(genres[i])).addCount(plays[i]);
        }

        // genreList는 총 재생 횟수에 따라 내림차순 정렬
        Collections.sort(genreList, (o1, o2) -> Integer.compare(o2.count ,o1.count));


        //2. 장르별 순위 매핑
        HashMap<String, Integer> ranking = new HashMap();
        int r = 0;
        for(int i=0; i< genreList.size(); i++){
            if(genreList.get(i) == null) break;
            // 앞에 위치한 장르부터 차례대로 랭킹 매김
            ranking.put(genreList.get(i).name, r++);
        }

        // 3. 음악
        Collections.sort(musicList, (o1, o2) -> {
            if(o2.value == o1.value){
                // 고유번호 더 낮은게 우선 순위
                return o1.index - o2.index;
            }
            return Integer.compare(o2.value, o1.value);
        });

        int[] arr = new int[200];
        Arrays.fill(arr, -1);
        int count = 0;

        for(int i=0; i<plays.length; i++){
            int start = ranking.get(musicList.get(i).genre)*2;
            if(arr[start] == -1){
                arr[start] = musicList.get(i).index;
                count++;
            }else if(arr[start+1] == -1){
                arr[start+1] = musicList.get(i).index;
                count++;
            }
        }

        // 4. 널 값없는 배열 만들기
        int [] answer = new int[count];
        int p=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != -1){
                answer[p++] = arr[i];
            }
        }


        return answer;
    }

    public static void main(String [] args){
        String [] arr = {"classic", "pop", "classic", "classic", "pop"};
        int [] arr2 = {500, 600, 150, 800, 2500};
        int [] result = solution(arr, arr2);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
class Music{
    String genre;
    int index;
    int value;

    public Music(String genre, int index, int value){
        this.genre = genre;
        this.index = index;
        this.value = value;
    }
}

class Genre{
    String name;

    int count;

    public Genre(String name, int count){
        this.name = name;

        this.count = count;
    }

    public void addCount(int add){
        this.count += add;
    }

}