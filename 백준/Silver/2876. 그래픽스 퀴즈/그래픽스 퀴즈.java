import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int grade [][] = new int [6][N];

        for(int i=0; i<N; i++){
            String [] nums = br.readLine().split(" ");
            int grade1 = Integer.parseInt(nums[0]);
            int grade2 = Integer.parseInt(nums[1]);

            if(i == 0){
                grade[grade1][i] = 1;
                grade[grade2][i] = 1;
                continue;
            }
            grade[grade1][i] = grade[grade1][i-1] +1;
            grade[grade2][i] = grade[grade2][i-1] +1;
        }


        int maxCount = 0;
        int maxGrage = 1;
        // max 구하기
        for(int i=0; i<N; i++){
            for(int g = 1; g <=5; g++){
                if(grade[g][i] > maxCount){
                    maxCount = grade[g][i];
                    maxGrage = g;
                }
            }
        }


        System.out.println(maxCount +" " + maxGrage);

    }






}
