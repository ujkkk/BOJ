import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        long S =0, P=0;
        S = sc.nextInt();
        P = sc.nextInt();

        String text = sc.next();
        int [] answer = new int[4];
        int [] temp = new int[4];
        for(int i=0; i<4; i++){
            answer[i] = sc.nextInt();
        }

        int a=0, b=0;
        int result = 0;
        while(b<P){
            if(text.charAt(b) == 'A'){
                temp[0]++; b++;
            }else if(text.charAt(b) == 'C'){
                temp[1]++; b++;
            }else if(text.charAt(b) == 'G'){
                temp[2]++; b++;
            }else if(text.charAt(b) == 'T'){
                temp[3]++; b++;
            }
        }

        while(true){
            if(answer[0] <= temp[0] && answer[1] <= temp[1] &&
                    answer[2] <= temp[2] &&answer[3] <= temp[3]){
                result++;

            }
            if(b==S) break;
            if(text.charAt(a) == 'A'){
                temp[0]--;
            }else if(text.charAt(a) == 'C'){
                temp[1]--;
            }else if(text.charAt(a) == 'G'){
                temp[2]--;
            }else if(text.charAt(a) == 'T'){
                temp[3]--;
            }

            if(text.charAt(b) == 'A'){
                temp[0]++;
            }else if(text.charAt(b) == 'C'){
                temp[1]++;
            }else if(text.charAt(b) == 'G'){
                temp[2]++;
            }else if(text.charAt(b) == 'T'){
                temp[3]++;
            }
            a++; b++;

        }
        System.out.println(result);

    }
}