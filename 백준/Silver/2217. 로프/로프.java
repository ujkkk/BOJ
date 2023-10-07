import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    BufferedReader br;
    int N;
    ArrayList<Integer> nums;
    int maxWegiht;

    public Main(){
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public void run() throws Exception{
        input();
        solution();
        print();
    }

    public void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<Integer>();

        for(int i=0; i< N; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }
    }

    public void solution(){
        int count = 1;
        // 내림차순 정렬
        nums.sort(Comparator.reverseOrder());
        maxWegiht = nums.get(0);

        for(int i=1; i< nums.size(); i++){
            count++;
            if(maxWegiht < nums.get(i)*count){
                maxWegiht = nums.get(i)*count;
            }
          
        }
    }

    public void print(){
        System.out.println(maxWegiht);
    }

    public static void main(String [] args) throws Exception{
        new Main().run();
    }
}
