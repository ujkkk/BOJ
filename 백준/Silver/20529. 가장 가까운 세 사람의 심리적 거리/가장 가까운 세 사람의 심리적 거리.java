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
            // 무조건적으로 3명의 MBTI가 겹칠 때
            if(N >32){
                bw.write(0+"\n");
                continue;
            }

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
                    // 친구 1과 친구 2의 관계
                    int s1ToS2 = getMindDistance(existMbtis[i], existMbtis[j]);

                    for(int k=0; k<existMbtis.length; k++){
                        // 해당 MBTI를 가진 사람이 1명 이하이면 중복은 불가하므로 패스
                        if(i==k && mbtiContainer.get(existMbtis[i]) <= 1)
                            continue;
                        if(j==k && mbtiContainer.get(existMbtis[j]) <= 1)
                            continue;
                        // 친구 1과 친구 2,친구 3까지 같을 때 해당 mbti를 가진 사람이 3명 미만이면 패스
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

