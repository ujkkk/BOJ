import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

            int sum = 0;
            int [] nums = new int[9];

            for(int i=0; i<9; i++){
                nums[i] = Integer.parseInt(br.readLine());
                sum += nums[i];
            }

            // 두명식 선택
            boolean isEnd = false;
            for(int i=0; i<8; i++){
                if(isEnd){
                    break;
                }
                for(int j=i+1; j<9; j++){
                    if(sum - nums[i] - nums[j] == 100){
                        for(int k=0; k<9; k++){
                            if(k == i || k == j){
                                continue;
                            }
                            bw.write(nums[k] +"\n");
                        }
                        isEnd = true;
                        break;
                    }
                }
            }

            bw.flush();
    }
}
