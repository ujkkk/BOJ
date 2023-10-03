import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int [] parnet;
    static List<Integer> [] tree;
    static int root = 0;
    static Boolean []  visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parnet = new int[n+1];
        tree = new ArrayList[n+1];
        visited = new Boolean[n+1];
        Arrays.fill(visited, false);

        for(int i=0; i<n; i++){
            tree[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = -1;
        while(st.hasMoreTokens()){
            i++;
            int parentValue = Integer.parseInt(st.nextToken());
            parnet[i] = parentValue;
            if(parentValue != -1){
                tree[parentValue].add(i);
            }

        }

        int deleteNode = Integer.parseInt(br.readLine());
        int deleteNodeParent = parnet[deleteNode];

        // 루트를 제거할 시
        if(deleteNodeParent == -1 ){
            System.out.println(0);
        }

        else{
            int idx = 0;
            for(int value :tree[deleteNodeParent] ){
                if(value == deleteNode){
                    tree[deleteNodeParent].remove(idx);
                    break;
                }
                idx++;
            }

            // 루트 찾기
            idx = 0;
            for(int p : parnet){
                if(p == -1){
                    root = idx;
                    break;
                }
                idx++;
            }

            // 트리 탐색
            visited[root] = true;
            findLeafNodeCount(root);
            System.out.println(result);
        }

    }

   static void findLeafNodeCount(int root){
        // bfs
       if(tree[root].size() == 0){
           result++;
           return;
       }
       Iterator<Integer> iterator = tree[root].iterator();

       while(iterator.hasNext()){
           int v = iterator.next();
           if(!visited[v]){
               visited[v] = true;
               findLeafNodeCount(v);
           }

       }
   }

}




