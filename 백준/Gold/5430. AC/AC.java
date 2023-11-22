import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deque;
        for(int t=0; t<T; t++){
            deque = new ArrayDeque<>();
            String input = br.readLine();
            int n = Integer.parseInt(br.readLine());

            char[] charArray  = br.readLine().toCharArray();
            char[] resultArray = new char[charArray.length - 2];
            // [,] 빼고 복사
            System.arraycopy(charArray, 1, resultArray, 0, charArray.length - 2);

            // 덱에 수 삽입
            String finalInput = new String(resultArray);
            String nums [] = finalInput.split(",");
            for(int i=0; i<nums.length; i++){
                try{
                    deque.add(Integer.parseInt(nums[i]));
                }catch (NumberFormatException e){
                    continue;
                }

            }

            boolean isNatural = true;
            boolean isError = false;
            for(int i=0; i<input.length(); i++){
                // 바꾸기
                if(input.charAt(i) == 'R'){
                    isNatural = !isNatural;
                }

                // 버리기
                else if(input.charAt(i) == 'D'){
                    if(deque.isEmpty()){
                        bw.write("error\n");
                        isError = true;
                        break;
                    }

                    // 수 버리기
                    if(isNatural){
                        deque.pollFirst();
                    } else{
                        deque.pollLast();
                    }
                }
            }
            if(isError)
                continue;

            // 출력
            if(deque.isEmpty()){
                bw.write("[]\n");
                continue;
            }
            if(isNatural){
                bw.write("[");
                int p;
                while(true){
                    p = deque.pollFirst();
                    if(deque.isEmpty())
                        break;
                    bw.write(p+",");
                }
                bw.write(p+"]\n");
            }
            else{
                bw.write("[");
                int p;
                while(true){
                    p = deque.pollLast();
                    if(deque.isEmpty())
                        break;
                    bw.write(p+",");
                }
                bw.write(p+"]\n");
            }

        }
        bw.flush();

        bw.close();
        br.close();
    }


}

