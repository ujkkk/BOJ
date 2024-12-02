import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int start = 0;
        int end = -1;

        // init
        int maxCount = 0;
        int curCount = 0;
        HashMap<Character, Integer> set = new HashMap<>();
        while(set.size() != N && end < str.length() -1){
            end++;
            set.put(str.charAt(end), set.getOrDefault(str.charAt(end), 0) +1);
            curCount++;
        }

        maxCount = curCount;

        while (end < str.length() -1){
            end++;
            set.put(str.charAt(end), set.getOrDefault(str.charAt(end) , 0) +1);
            curCount++;

            if(set.size() == N+1){
                while(start < end && set.size() == N+1){
                    char removeAlpha = str.charAt(start);

                    while(start < end && str.charAt(start) == removeAlpha){
                        start++;
                        curCount--;
                        set.put(removeAlpha, set.get(removeAlpha) -1);
                    }

                    if(set.get(removeAlpha) == 0){
                        set.remove(removeAlpha);
                    }
                }

            }
            maxCount = Math.max(curCount, maxCount);
        }

        bw.write(maxCount+"");
        bw.flush();
    }
}
