import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0, start_index = 0, end_inedx = 0;
        int result = 1;

        while(end_inedx < N && start_index < N){
            if(sum == N){
                result++;
                end_inedx++;
                sum += end_inedx;
            }
            else if(sum > N){
                sum -= start_index;
                start_index++;
            }
            else if(sum < N){
                end_inedx++;
                sum += end_inedx;
            }
            
        }
        System.out.println(result);
    }
}