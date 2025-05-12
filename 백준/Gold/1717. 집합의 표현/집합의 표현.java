import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int [] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 1~n까지 원소
        int M = Integer.parseInt(st.nextToken());   // 연산의 수;

        StringBuilder sb = new StringBuilder();
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0){
                union(a,b);
            }
            else if(op == 1){
                if(isSameSet(a, b)){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean isSameSet(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b){
            return true;
        }else{
            return false;
        }
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
