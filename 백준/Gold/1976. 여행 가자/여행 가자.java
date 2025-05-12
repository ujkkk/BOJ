import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int [] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int op = Integer.parseInt(st.nextToken());
                if(op == 1){
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int pre = -1;
        for(int i=0; i<M; i++){
            if(i==0){
                pre = Integer.parseInt(st.nextToken());
                continue;
            }
            int cur = Integer.parseInt(st.nextToken());
            if(find(pre) != find(cur)){
                System.out.println("NO");
                return;
            }
            pre = cur;
        }
        System.out.println("YES");
    }


    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
