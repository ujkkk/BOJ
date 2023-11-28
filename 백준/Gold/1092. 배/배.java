import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br;
    static BufferedWriter bw;
    static List<Crane> crane;
    static List<Integer> boxs;
    static int N;
    static int M;
    static int ans;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void run() throws Exception {
        input();
        solution();
        output();
    }

    public static void input() throws Exception {
        crane = new ArrayList<>();
        boxs = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 상자 제한 무게 입력
        for(int i=0; i<N; i++){
            int limit = Integer.parseInt(st.nextToken());
            crane.add(new Crane(limit));
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // 박스 무게 입력
        for(int i=0; i<M; i++){
            boxs.add(Integer.parseInt(st.nextToken()));
        }
    }

    public static void solution(){
        // 박스 내림차순 정렬
        boxs.sort(Comparator.reverseOrder());
        // 크레인 내림차순 정렬
        crane.sort(new Comparator<Crane>() {
            @Override
            public int compare(Crane o1, Crane o2) {
                return o2.limit- o1.limit;
            }
        });

        // 크레인이 이동 시켜야 할 상자 갯수
        int result [] = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);

        int boxIdx, craneIdx;
        for(boxIdx=0; boxIdx< M; boxIdx++){
            int crainNumber = 0;
            for(craneIdx = 0; craneIdx<N; craneIdx++){
                Crane curCrain = crane.get(craneIdx);
                if(curCrain.limit < boxs.get(boxIdx))
                    break;
                // 작은 count를 가지는 crain찾기
                if(curCrain.count <= crane.get(crainNumber).count){
                    crainNumber = craneIdx;
                }
            }
            // 어떠한 크레인으로도 들 수 없을 때
            if(craneIdx==0){
                ans = -1;
                return;
            }
            // 해당 크레인의 count 1증가
            crane.get(crainNumber).addBox();
        }

        // 가장 큰 count 구하기
        int max = Integer.MIN_VALUE;
        for(Crane c : crane){
            if(c.count > max){
                max = c.count;
            }
        }
        ans = max;
    }
    public static void output() throws Exception{
        bw.write(ans+"\n");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void main(String [] args) throws Exception{
        new Main().run();
    }
}

class Crane {
    int limit;
    int count;

    public Crane(int limit){
        this.limit = limit;
        this.count = 0;
    }

    public void addBox(){
        count++;
    }
}