import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Crain> crains = new ArrayList<>();
        int [] boxs;

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 상자 제한 무게 입력
        for(int i=0; i<N; i++){
            int limit = Integer.parseInt(st.nextToken());
            crains.add(new Crain(limit));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boxs = new int[M];
        // 박스 무게 입력
        for(int i=0; i<M; i++){
            boxs[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(boxs);
        // 크레인 내림차순 정렬
        crains.sort(new Comparator<Crain>() {
            @Override
            public int compare(Crain o1, Crain o2) {
                return o1.limit- o2.limit;
            }
        });
        // 크레인이 이동 시켜야 할 상자 갯수
        int result [] = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);

        for(int m=M-1; m>=0; m--){
            int crainNumber = (N-1);
            int c;
            for(c = N-1; c>=0; c--){
                Crain curCrain = crains.get(c);
                if(curCrain.limit < boxs[m])
                    break;
                // 작은 count를 가지는 crain찾기
                if(curCrain.count < crains.get(crainNumber).count){
                    crainNumber = c;
                }
            }
            if(c==N-1){
                System.out.println("-1");
                return;
            }
            crains.get(crainNumber).addBox();

        }

        // 가장 큰 count 구하기
        int max = Integer.MIN_VALUE;
        for(Crain c : crains){
            if(c.count > max){
                max = c.count;
            }
        }
        bw.write(max+"\n");
        bw.flush();

        bw.close();
        br.close();

    }
}

class Crain {
    int limit;
    int count;

    public Crain(int limit){
        this.limit = limit;
        this.count = 0;
    }

    public void addBox(){
        count++;
    }

}