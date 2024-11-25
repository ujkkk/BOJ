import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int [] dishes = new int[N];
        for(int i=0; i<N; i++){
            dishes[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> eaten = new HashMap<>();
        boolean isBonus = false;

        int notEat = -1;
        int eat = -1;

        // 초기셋팅
        for(int i=0; i<k; i++){
            eat++;
            eaten.put(dishes[eat], eaten.getOrDefault(dishes[eat], 0) +1);

            // 보너스 초밥 체크
            if(dishes[eat] == c){
                isBonus = true;
            }
        }
        int max = isBonus? eaten.size(): eaten.size() +1;

        int count = 0;
        while(count < N + k +2){
            count++;

            // 초밥 먹기
            eat = (eat+1)%N;
            eaten.put(dishes[eat], eaten.getOrDefault(dishes[eat], 0) +1);
            if(dishes[eat] == c){
                isBonus = true;
            }

            // 먹은 초밥 빼기
            notEat = (notEat+1)%N;
            int removeDish = dishes[notEat];
            if(eaten.get(removeDish) == 1){
                eaten.remove(removeDish);
                // 보너스 초밥 체크
                if(removeDish == c){
                    isBonus = false;
                }
            }
            else{
                eaten.put(removeDish, eaten.get(removeDish)-1);
            }

            // 최대값 체크
            max = Math.max(isBonus? eaten.size(): eaten.size() +1, max);
            if(max == k+1){
                break;
            }
        }

        System.out.println(max);
    }
 }
