import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Line [] lines = new Line[N];

        StringTokenizer st;
        // 선 정보 입력 받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines[i] = new Line(start, end);
        }
        // 시작 선을 기준으로 오름차순
        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int start = lines[0].start;
        int end =  lines[0].end;
        long sum = 0L;
        for(int i=1; i<N; i++){
            Line line = lines[i];
            // 새로운 선 추가
            if(line.start > end){
                // 이전의 선 길이 더하기
                sum += Math.abs(end - start);
                // 새로운 선의 시작점
                start = line.start;
            }
            // 기존 선 연장
            if(line.end > end)
                end = line.end;

        }

        // 마지막 선 길이 더하기
        sum += Math.abs(end - start);
        bw.write(sum+"\n");
        bw.flush();

        bw.close();
        br.close();

    }
}

class Line{
    int start;
    int end;

    public Line(int start ,int end){
        this.start = start;
        this.end = end;
    }
}