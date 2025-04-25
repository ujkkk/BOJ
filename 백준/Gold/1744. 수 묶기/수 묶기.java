import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = 0;
    private static int N;

    public static void main(String[] args) throws IOException {

       // 큰거 2개를 묶는 것이 유리함 단. x*y > x+y
        // 마이너스는 마이너스끼리, 플러스는 플러스끼리

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > 0){
                plus.add(n);
            }
            else{
                minus.add(n);
            }
        }

        int sum = 0;
        // plus
        Collections.sort(plus, Collections.reverseOrder());
        for(int i=0; i<plus.size(); i+=2){
            if(i == plus.size() -1){
                sum += plus.get(i);
                break;
            }

            sum += Math.max(plus.get(i)*plus.get(i+1),
                plus.get(i)+plus.get(i+1));
        }

        // minus
        Collections.sort(minus);
        for(int i=0; i<minus.size(); i+=2){
            if(i == minus.size() -1){
                sum += minus.get(i);
                break;
            }

            sum += Math.max(minus.get(i)*minus.get(i+1),
                minus.get(i)+minus.get(i+1));
        }

        System.out.println(sum);
    }
}
