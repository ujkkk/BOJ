import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int soloCount;
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){

            int N = Integer.parseInt(br.readLine());
            int [] select = new int[N+1];
            soloCount = N;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                select[i] = Integer.parseInt(st.nextToken());
            }

            boolean [] isVisited = new boolean[N+1];

            for(int i=1; i<=N; i++){
                if(!isVisited[i]){
                    dfs(i, select, isVisited,new ArrayList<>());
                }
            }
            bw.write(soloCount+"\n");
        }
        bw.flush();
    }

    private static void dfs(int currentId, int [] select, boolean[] isVisited, ArrayList<Integer> cycleList) {
        cycleList.add(currentId);
        isVisited[currentId] = true;

        int nextId = select[currentId];

        if(!isVisited[nextId]){
            dfs(nextId, select, isVisited, cycleList);
        }
        else{
            // 현재 dfs에서 방문을 함
            if(cycleList.contains(nextId)){
                soloCount -= cycleList.size() - cycleList.indexOf(nextId);
            }
        }
    }


}

