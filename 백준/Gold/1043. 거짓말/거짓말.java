import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


class Main
{
    static HashSet<Integer> truePerson;
    static List<Integer>[] people;
    static List<Integer>[] parties;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        truePerson = new HashSet();
        if(truth != 0){
            // 진실을 아는 사람들 입력 받음
            for(int i=0; i<truth; i++){
                truePerson.add(Integer.parseInt(st.nextToken()));
            }
        }

        people = new ArrayList[N+1];
        parties = new ArrayList[M];
        for(int i=0; i<N+1; i++){
            people[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            parties[i] = new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int i=0; i<n;i++){
                int node = Integer.parseInt(st.nextToken());
                parties[m].add(node);

            }
            // 관계 형성
            for(int node : parties[m]){
                for(int me : parties[m]){
                    if(node == me)
                        continue;
                    people[me].add(node);
                }
            }
        } // 파티 정보 입력 끝

        int result = 0;
        for(int m=0; m<M;m++){
            boolean [] isVisited = new boolean[N+1];
            if(BFS(m, isVisited))
                result++;
        }

        bw.write(result +"\n");

        bw.flush();

        bw.close();
        br.close();

    }

    public static boolean BFS(int n,  boolean [] isVisited){
        Queue<Integer> que = new LinkedList<>();
        for(int node : parties[n]){
            if(truePerson.contains(node))
                return false;
            que.add(node);
            isVisited[node] = true;
        }

        while(!que.isEmpty()){
            int current = que.poll();
            if(truePerson.contains(current))
                return false;
            for(int node : people[current]){
                if(!isVisited[node]){
                    que.add(node);
                    isVisited[node] = true;
                }
            }
        }
        return true;
    }

}

