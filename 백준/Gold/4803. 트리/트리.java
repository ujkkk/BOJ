import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int testCase = 0;
        while(true){
            testCase++;

            String [] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);

            if(n == 0 && m == 0){
                break;
            }

            // 트리 형성
            ArrayList<Integer> [] tree = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                tree[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                String [] edge = br.readLine().split(" ");
                int v = Integer.parseInt(edge[0]);
                int w = Integer.parseInt(edge[1]);

                tree[v].add(w);
                tree[w].add(v);
            }

            int result = 0;
            boolean []  check = new boolean[n+1];
            for(int i=1; i<=n; i++){
                if(check[i]){
                    continue;
                }
                if(isTree( i, 0, tree, check)){
                    result++;
                }
            }
            bw.write(printResult(testCase, result)+"\n");

        }
        bw.flush();
    }
    static String printResult(int t, int n){
        StringBuilder sb = new StringBuilder();
        sb.append("Case ").append(t).append(": ");
        switch (n){
            case 0:
                sb.append("No trees.");
                break;
            case 1:
                sb.append("There is one tree.");
                break;
            default:
                sb.append("A forest of " + n + " trees.");
        }
        return sb.toString();
    }

    static boolean isTree(int n, int parent, ArrayList<Integer>[] tree, boolean[] check){
        for(int next: tree[n]){
            if(next == parent){
                continue;
            }
            if(check[next]){
                return false;
            }
            check[next] = true;

            if (!isTree(next, n, tree, check)){
                return false;
            }
        }
        return true;
    }


}


