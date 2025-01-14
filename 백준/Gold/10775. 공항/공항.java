import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        boolean [] isSelected = new boolean[G+1];
        int [] parent = new int[G+1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        for(int i=0; i<P; i++){
            int cur = Integer.parseInt(br.readLine());

            while(true){
                // 선택 안됐으면 도킹
                if(!isSelected[cur]){
                    isSelected[cur] = true;
                    break;
                }

                // 선택된 게이트 일 때
                int next = parent[cur]-1;
                if(next <= 0 ){
                    System.out.println(i);
                    return;
                }

                cur = find(cur, parent);
                int p = find(next, parent);

                if(cur < p){
                    parent[p] = cur;
                }
                else{
                    parent[cur] = p;
                }

                if(!isSelected[next]){
                    isSelected[next] = true;
                    break;
                }
                cur = p;
            }
        }
        System.out.println(P);
    }

    private static int find(int a, int [] parent){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a], parent);
    }

}

