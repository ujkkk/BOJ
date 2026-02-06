import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());    // 스위치 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean [] switches = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(Integer.parseInt(st.nextToken()) == 1){
                switches[i] = true;
            }
        }

        int studentN = Integer.parseInt(br.readLine());

        for(int i=0; i<studentN; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int switchN = Integer.parseInt(st.nextToken());

            if(type == 1){
                boySwitchOn(switchN, N, switches);
            }
            else{
                girlSwitchOn(switchN, N, switches);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(switches[i]){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
            if((i)%20 == 0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void girlSwitchOn(int switchN, int N, boolean[] switches) {
        int left = switchN -1;
        int right = switchN + 1;
        switches[switchN] = !switches[switchN];

        while(true){
            if(left < 1) break;
            if(right > N) break;

            if(switches[left] != switches[right]) break;

            switches[left] = !switches[left];
            switches[right] = !switches[right];

            left--;
            right++;

        }
    }

    private static void boySwitchOn(int switchN, int N, boolean[] switches) {
        for(int i= switchN; i<= N; i+= switchN){
            switches[i] = !switches[i];
        }
    }
}
