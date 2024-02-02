
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int N, M;
    static int [] parent;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1; i<parent.length; i++)
            parent[i] = i;

        StringTokenizer st;
        for(int r =1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c =1; c<=N; c++){
                int value = Integer.parseInt(st.nextToken());
                if(c<r) continue;

                if(value == 1)
                    union(r,c);
            }
        }
        // 여행 계획
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int rootParent = find(start);

        boolean result = true;
        while(st.hasMoreTokens()){
            if(find(Integer.parseInt(st.nextToken())) != rootParent){
                result = false;
                break;
            }
        }
        if(result)
            bw.write("YES");
        else
            bw.write("NO");

        bw.flush();
        br.close();
        bw.close();

    }

    public static boolean checkSame(int a, int b){
        if(find(a) == find(b))
            return true;
        return false;
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b)
            return;
        parent[b] = a;
    }

    public static int find(int a){
        // 대표 노드 찾음
        if(parent[a] == a)
            return a;

        parent[a] = find(parent[a]);
        return parent[a];
    }



}

