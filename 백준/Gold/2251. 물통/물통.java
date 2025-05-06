import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {


    public static int N, M, K, X;
    public static List<Integer>[] graph;
    public static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> maxVisited = new ArrayList<>();
    public static int [] max;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

       StringTokenizer st = new StringTokenizer(br.readLine());
       max = new int[3];
       for(int i=0; i<max.length; i++){
           max[i] = Integer.parseInt(st.nextToken());
       }

        bfs();

    }


    public static void bfs(){
        HashSet<Integer> capacity = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer []> que = new LinkedList<>();
        que.add(new Integer[]{0, 0, max[2]});


        while(!que.isEmpty()){
            Integer [] cur = que.poll();
            visited.add(toInt(cur));

            if(cur[0] == 0){
                if(capacity.contains(cur[2])) continue;
                capacity.add(cur[2]);
            }

            // A 물통이 꽉 차지 않을 때
            if(cur[0] != max[0]){
                // B -> A
                if(cur[1] != 0){
                    Integer [] l = change(1, 0, max, cur);
                    if(!visited.contains(toInt(l)))
                        que.add(l);
                }
                // C -> A
                if(cur[2] != 0){
                    Integer [] l = change(2, 0, max, cur);
                    if(!visited.contains(toInt(l)))
                        que.add(l);
                }
            }

            // B 물통이 꽉 차지 않을 때
            if(cur[1] != max[1]){
                // A -> B
                if(cur[0] != 0){
                    Integer [] l = change(0, 1, max, cur);
                    if(!visited.contains(toInt(l)))
                        que.add(l);
                }
                // C -> b
                if(cur[2] != 0){
                    Integer [] l = change(2, 1, max, cur);
                    if(!visited.contains(toInt(l)))
                        que.add(l);
                }
            }

            // C 물통이 꽉 차지 않을 때
            if(cur[2] != max[2]){
                // B -> C
                if(cur[1] != 0){
                    Integer [] l = change(1, 2, max, cur);
                    if(!visited.contains(toInt(l)))
                        que.add(l);
                }
                // A -> C
                if(cur[0] != 0){
                    Integer [] l = change(0, 2, max, cur);
                    if(!visited.contains(toInt(l)))
                        que.add(l);
                }
            }
        }

        Integer[] array =  capacity.toArray(new Integer[0]);
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i :array){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    private static int toInt(Integer [] list){
        return list[0]*13 + list[1] *1300 + list[2]*130000;
    }

    private static Integer [] change(int idx1, int idx2, int [] max, Integer [] cur){
        Integer [] copy = cur.clone();
        // idx1 -> idx2로
        if(copy[idx2] + copy[idx1] > max[idx2]){
            copy[idx1] = copy[idx1]- (max[idx2] - cur[idx2]);
            copy[idx2] = max[idx2];
        }
        else{
            copy[idx2] += copy[idx1];
            copy[idx1] = 0;
        }
        return copy;
    }
}
