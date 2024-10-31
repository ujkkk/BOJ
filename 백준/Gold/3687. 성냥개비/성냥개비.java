import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) throws IOException {

        String [] dpMax = new String[110]; // dp[count][cost] : cost개의 성냥을 뽑아 십진수 count개를 만들 때 최대
        long [] dpMin = new long[110]; // dp[count][cost] : cost개의 성냥을 뽑아 십진수 count개를 만들 때 최대

        int [] idxs = new int[]{2,3,4,5,6,7};
        String [] max = new String[8];
        max[2] = "1";     // 2개의 성냥을 소모할 때 얻을 수 있는 최대 십진수
        max[3] = "7";
        max[4] = "4";
        max[5] = "5";
        max[6] = "9";
        max[7] = "8";

        for(int i=0; i<idxs.length; i++){
            dpMax[idxs[i]] = max[idxs[i]];
        }
        // 최대 구하기
        for(int i=1; i<101; i++){
            if(dpMax[i] == null)
                continue;

            for(int idx : idxs){
                if( dpMax[i+idx] == null){
                    dpMax[i+idx] = dpMax[i] +max[idx];
                    continue;
                }
                // 크기 우선
                String cur = dpMax[i]+ max[idx];
                String pre = dpMax[i + idx];

                int l1 = cur.length();
                int l2 = pre.length();

                // 크기 비교
                if(l1 > l2){
                    // 갱신
                    dpMax[i+ idx] = cur;
                }
                // 크기가 같으면 사전순 비교
                else if(l1 == l2){
                    if((cur).compareTo(pre) > 0) {
                        dpMax[i+ idx] = cur;
                    }
                }
            }
        }

        // 최소 구하기
        // 최소 구하기
        int [] min = new int[8];
        min[2] = 1;     // 2개의 성냥을 소모할 때 얻을 수 있는 최소 십진수
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 0;
        min[7] = 8;


        for(int i=0; i<idxs.length; i++){
            dpMin[idxs[i]] = min[idxs[i]];
        }
        // 처음에 0을 넣으면 안됨
        dpMin[6] = 6;

        // 최소 구하기
        for(int i=1; i<101; i++){

            if(dpMin[i] == 0)
                continue;

            for(int idx : idxs){
                if( dpMin[i+idx] == 0){
                    dpMin[i+idx] =  dpMin[i]*10 + min[idx];
                }
                else{
                    dpMin[i+idx] = Math.min(dpMin[i+idx], dpMin[i]*10 + min[idx]);

                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dpMin[n] +" " +dpMax[n] +"\n");
        }






        bw.flush();
    }



}

