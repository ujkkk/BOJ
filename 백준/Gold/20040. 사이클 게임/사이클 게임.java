import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int [] parent;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 점의 개수
        M = Integer.parseInt(st.nextToken());   // 진행 턴

        parent = new int[N];
        // 자기 자신으로 초기화
        for(int i=0; i<N; i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a= find(a);
            b = find(b);

            if(a == b){
                result = i;
                break;
            }

            // union
            parent[b] = a;
        }

        System.out.println(result+"");
    }

    public static int find(int n){
        if(parent[n] == n){
            return n;
        }

        return parent[n] = find(parent[n]);
    }

}

