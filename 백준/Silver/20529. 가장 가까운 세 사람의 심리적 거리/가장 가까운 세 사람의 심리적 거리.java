import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t =1; t<=T; t++){
            HashMap<String, Integer> mbtiContainer = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String mbti = st.nextToken();
                int count = mbtiContainer.getOrDefault(mbti, 0) +1;
                mbtiContainer.put(mbti, count);
            }

            String[] existMbtis = mbtiContainer.keySet().toArray(new String[0]);
            int result = Integer.MAX_VALUE;
            for(int i=0; i<existMbtis.length; i++){
                // 첫번쨰 친구와 두 번쨰 친구
                for(int j=0; j< existMbtis.length; j++){
                    // 중복인데 해당 mbti가 1명뿐이면 패스
                    if(i==j && mbtiContainer.get(existMbtis[i]) == 1)
                        continue;
                    int s1ToS2 = getMindDistance(existMbtis[i], existMbtis[j]);

                    for(int k=0; k<existMbtis.length; k++){
                        if(i==k && mbtiContainer.get(existMbtis[i]) <= 1)
                            continue;
                        if(j==k && mbtiContainer.get(existMbtis[j]) <= 1)
                            continue;
                        if(i==j && j==k && mbtiContainer.get(existMbtis[i]) <=2)
                            continue;

                        int s2ToS3 = getMindDistance(existMbtis[j], existMbtis[k]);
                        int s1ToS3 = getMindDistance(existMbtis[i], existMbtis[k]);
                        result = Math.min(result, s1ToS3 + s2ToS3 + s1ToS2);
                    }
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static int getMindDistance(String s1, String s2){
        // 글자가 다르면 count 증가
        int count = 0;
        for(int i =0; i<4; i++){
            if((s1.charAt(i) != s2.charAt(i)))
                count++;
        }
        return count;
    }
}

