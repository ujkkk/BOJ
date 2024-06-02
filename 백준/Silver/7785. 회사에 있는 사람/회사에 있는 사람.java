import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        HashSet<String> working = new HashSet<>();

        for(int i=0; i<N; i++){
            String info [] = br.readLine().split(" ");
            String name = info[0];
            String visit = info[1];

            if(visit.equals("enter")){
                working.add(name);
            } else{
                if(working.contains(name)){
                    working.remove(name);
                }
            }
        }
        Iterator<String> iterator =  working.iterator();
        List<String> has = new ArrayList<>();
        while(iterator.hasNext()){
            has.add(iterator.next());
        }
        Collections.sort(has, Collections.reverseOrder());
        for(String name : has){
            bw.write(name+"\n");
        }
        bw.flush();
    }



}


