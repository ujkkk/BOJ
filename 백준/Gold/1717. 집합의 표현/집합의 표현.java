
import java.io.*;
import java.util.*;
import java.util.logging.Handler;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int [] root;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new int [n+1];
        // 처음 모든 루트는 자기 자신
        for(int i=1; i<root.length; i++){
            root[i] = i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // union
            if(op == 0){
                union(a,b);
            }else{
                // 같은 집합에 속하는지 체크
                if(check(a,b))
                    bw.write("YES\n");
                else
                    bw.write("NO\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();

    }

    // union - 대표 노드끼리 연결하기
    public static void union(int a, int b){
        // a원소가 포함된 집합의 대표 원소를 찾음
        a = find(a);
        b = find(b);
        // 같은 집합에 속하는지 체크
        if(a==b)
            return;
        // 같은 집합이 아니라면 합치기 진행
        // b 집합의 대표를 a 집합의 대표로
        root[b] = a;
    }

    public static int find(int a){
        if(root[a] == a){
            return a;
        }
        root[a] = find(root[a]);
        return root[a];
    }

    public static boolean check(int a, int b){
        if(find(a) == find(b))
            return true;
        return false;
    }
}

