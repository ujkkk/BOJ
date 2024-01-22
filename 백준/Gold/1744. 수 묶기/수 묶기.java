import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static int zeroCount =0;
    static int positiveCount = 0;
    static int negativeCount=0;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        int ans = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                zeroCount++;
                continue;
            } else if(num == 1){
                // 1은 무조건 더해줌
                ans++;
                continue;
            }else if(num>0){
                positiveCount++;
            } else{
                negativeCount++;
            }
            nums.add(num);
        }
        // 오름차순 정렬
        Collections.sort(nums);

        // 음수
        int size = nums.size();
        int num1,num2;
        int i;
        
        for(i=0; i<negativeCount; i=i+2){
            // 음수의 개수가 홀수이면 제일 마지막 음수를 그냥 더해줌
            if(i == negativeCount -1 && negativeCount%2 == 1){
                // 0이 하나도 없으면 음수를 더해줌
                if(zeroCount == 0) 
                    ans+= nums.get(i);
                break;
            }
            // 두 개씩 짝짓기
            num1 = nums.get(i);
            num2 = nums.get(i+1);

            ans += num1*num2;
        }

        // 양수
        for(int j=negativeCount; j<size; j=j+2){
            // 양수의 개수가 홀수이면 가장 앞(가장 작은 수) 수를 더하기
            if(positiveCount%2 == 1 && j== negativeCount){
                ans += nums.get(j);
                j--;
                continue;
            }
            // 두 개씩 짝짓기
            num1 = nums.get(j);
            num2 = nums.get(j+1);

            ans += num1*num2;
        }

        bw.write(ans+"\n");
        bw.flush();

        bw.close();
        br.close();

    }
}