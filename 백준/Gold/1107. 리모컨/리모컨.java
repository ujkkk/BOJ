import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int currentNum;
    static long min;
    static boolean [] isBroken;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strNum =br.readLine();
        currentNum = Integer.parseInt(strNum);
        int brokenCount = Integer.parseInt(br.readLine());
        isBroken  = new boolean[10];

        if(brokenCount != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i< brokenCount; i++){
                int n = Integer.parseInt(st.nextToken());
                isBroken[n] = true;
            }
        }

        // 타겟이 100번인 경우
        if(currentNum == 100){
            System.out.println("0");
            return;
        }


        // 망가지지 않은 수 넣기
        HashSet<Integer> nums = new HashSet<>();
        for(int i=0; i<9; i++){
            if(!isBroken[i])
                nums.add(i);
        }

        currentNum = Integer.parseInt(strNum);
        // 100번 채널에서 +, -로만 이동
        min = Math.abs(currentNum - 100);

        dfs(0, "");
        bw.write( min+ "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, String clicked){
        for(int i=0; i<isBroken.length; i++){
            if(isBroken[i]) continue;

            String newStr = clicked + Integer.toString(i);
            // 숫자를 만들고 빼봤을 떄 더 작은거
            int cnt = Math.abs(currentNum - Integer.parseInt(newStr)) + newStr.length();
            min = Math.min(cnt, min);
            // 최대가 6자리이므로
            if(idx < 6) {
                dfs(idx+1, newStr);
            }
        }
    }

}