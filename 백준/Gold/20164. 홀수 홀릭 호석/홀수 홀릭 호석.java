import java.io.*;
import java.util.ArrayList;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static int min = Integer.MAX_VALUE;
    public static int max = 0;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        split(n, 0);

        System.out.println(min + " " + max);

    }

    private static int countOddNumber(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n % 10;
            if (tmp % 2 == 1) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }

    public static void split(int n, int count) {
        count += countOddNumber(n);

        if(n/10 == 0) {
            min = Math.min(min, count);
            max = Math.max(max,  count);
            return;
        }

        else if(n /100 == 0) {
            int next = n / 10;
            next += n % 10;
            split(next, count);
        }

        else {
            String str = String.valueOf(n);
            for(int i=0; i<str.length()-2; i++) {
                for(int j=i+1; j<str.length()-1; j++) {
                    int next = Integer.parseInt(str.substring(0, i+1));
                    next += Integer.parseInt(str.substring(i+1, j+1));
                    next += Integer.parseInt(str.substring(j+1));

                    split(next, count);

//                    int num1 = 0;
//                    int num2 = 0;
//                    int num3 = 0;
//
//                    for(int k=0; k<=i; k++) {
//                        num1 *= 10;
//                        num1 += n[k];
//                    }
//                    for(int l=i+1; l<=j; l++) {
//                        num2 *= 10;
//                        num2 += n[l];
//                    }
//                    for(int m=j+1; m<n.length; m++) {
//                        num3 *= 10;
//                        num3 += n[m];
//                    }
//
//                    int result = num1 + num2 + num3;
//                    ArrayList<Integer> list = new ArrayList();
//
//                    while(result != 0) {
//                        int number = result % 10;
//                        result/= 10;
//                        list.add(number);
//
//                    }
//
//                    split(list.stream().mapToInt(o->o).toArray(), count);
                }

            }
        }
    }
}





