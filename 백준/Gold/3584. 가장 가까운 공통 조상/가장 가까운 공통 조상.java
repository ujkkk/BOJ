
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static List<Integer>[] tree;
    static int [] parent, depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T>0){
            T--;
            int n = Integer.parseInt(br.readLine());

            parent = new int[n+1];
            depth = new int[n+1];
            tree = new ArrayList[n+1];

            // 초기화
            for(int i=1; i<= n; i++){
                tree[i] = new ArrayList<Integer>();
            }

            boolean [] isRoots = new boolean[n+1];
            Arrays.fill(isRoots, true);
            // 트리 완성
            for(int i=0; i< n-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                tree[parent].add(child);
                isRoots[child] = false;
            }

            int root = 0;
            for(int i=1; i<isRoots.length; i++){
                if(isRoots[i]){
                    root = i;
                    break;
                }
            }

            init(root, 1, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            System.out.println(LCA(x1,x2));

        }


    }

    static void init(int idx, int d, int p){
        parent[idx] = p;
        depth[idx] = d;
        for(int next : tree[idx]){
            if(next != p){
                init(next, d+1 , idx);
            }
//            else{
//                System.out.println("idx : "+idx +", next :"+ next);
//            }
        }
    }

    static int LCA(int a, int b){
        while(depth[a] > depth[b]){
            a = parent[a];
        }
        while(depth[b] > depth[a]){
            b = parent[b];
        }

        while(a!=b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

}



