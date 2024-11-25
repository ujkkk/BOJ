import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static Belt [] belts;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belts = new Belt[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            belts[i] = new Belt( Integer.parseInt(st.nextToken()), false); // 내구도 초기화
        }
        for(int i=2*N-1; i>= N; i--){
            belts[i] = new Belt( Integer.parseInt(st.nextToken()), false); // 내구도 초기화
        }

        int step = 0;
        while(true){
            step++;

            // 1. 벨트와 함께 로봇 이동
            moveBelt();

            // 2. 로봇 이동
            moveDolls();

            // 3. 로봇 올리기
            if(belts[0].durability > 0){
                belts[0].isDoll = true;
                belts[0].durability--;
            }

            // 4. 내구도 칸 확인
            if(getZeroDurabilityNumber() >= K){
                break;
            }

        }
        System.out.println(step);
    }

    public static void moveBelt(){
        Belt temp = belts[N-1];

        for(int i=N-1; i>=1; i--){
            belts[i] = belts[i-1];
        }
        belts[0] = belts[N];
        for(int i=N; i<= 2*N-2; i++){
            belts[i] = belts[i+1];
        }
        belts[2*N-1] = temp;

        belts[N-1].isDoll = false;
    }

    public static void moveDolls(){
        for(int i=N-2; i>=0; i--){
            // 벨트에 인형이 없음
            if(!belts[i].isDoll)
                continue;

            // 내리는 칸에 도착
            if(i == N-2 && belts[i+1].durability > 0){
                belts[i].isDoll = false;
                belts[i+1].durability--;
                continue;
            }

            if(belts[i+1].durability > 0 && !belts[i+1].isDoll){
                belts[i].isDoll = false;

                belts[i+1].isDoll = true;
                belts[i+1].durability--;
            }
        }
    }

    public static int getZeroDurabilityNumber(){
        int count = 0;
        for(int i=0; i<2*N; i++){
            if(belts[i].durability <= 0){
                count++;
            }
        }
        return count;
    }
 }
class Belt{
    int durability;
    boolean isDoll;

    public Belt(int durability, boolean isDoll) {
        this.durability = durability;
        this.isDoll = isDoll;
    }
}
