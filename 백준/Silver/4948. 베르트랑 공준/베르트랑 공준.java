import java.io.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static boolean [] isNotPrime;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        isNotPrime = new boolean[123_456*2+1];
        getPrime(isNotPrime);

        while (true){
            int N = Integer.parseInt(br.readLine());
            if(N==0)
                break;
            bw.write(getCount(N)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    public static int getCount(int n){
        int count = 0;
        for(int i=n+1; i<=2*n; i++){
            if(!isNotPrime[i]) count++;
        }
            return count;
    }
    public static void getPrime(boolean[] isNotPrime){
        int start = 2;
        int size = isNotPrime.length;
        while(start <= Math.sqrt(size)){
            for(int i=start*2; i<size; i = i+start){
                if(isNotPrime[i])
                    continue;
                isNotPrime[i] = true;
            }

            for(int i=start+1; i<size; i++){
                if(!isNotPrime[i]){
                    start = i;
                    break;
                }
            }
        }

    }

}