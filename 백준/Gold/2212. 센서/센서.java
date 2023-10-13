import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet nums = new TreeSet();
        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int diff [] = new int[nums.size()-1];
        Iterator<Integer> iterator = nums.iterator();
        int preN = iterator.next(); int curN;
        for(int i=0; i<nums.size()-1; i++){
            curN = iterator.next();
            diff[i] = curN - preN;
            preN = curN;
        }
        Arrays.sort(diff);
        int sum = 0;
        for(int i=0; i< diff.length - K +1; i++){
            sum+= diff[i];
        }

        System.out.println(sum);
    }
}
