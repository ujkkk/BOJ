
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            set1.add(br.readLine());
        }
        for(int i=0; i<M; i++){
            set2.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for(String name1 : set1){
            if(set2.contains(name1)){
                list.add(name1);
            }
        }

        Collections.sort(list);
        StringBuilder result = new StringBuilder();

        result.append(list.size()).append("\n");
        for(String name : list){
            result.append(name).append("\n");
        }
        System.out.println(result);
    }



}