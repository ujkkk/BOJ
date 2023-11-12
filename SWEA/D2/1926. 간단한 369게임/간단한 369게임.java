import java.io.*;


class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;

        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            int count =0;
            int num = i;
            int digit = 1;
            while(num > 0){
                num = num/digit;
                int n = num%10;
                digit*=10;

                if(n==3 || n == 6 || n==9){
                    count++;
                }
            }
            if(count == 0){
                bw.write(i + " ");
                continue;
            }
            for(int j=0; j<count; j++){
                bw.write("-");
            }
            bw.write(" ");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}