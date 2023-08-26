import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    static int disit;
    public static void main(String [] args) throws IOException{
        Scanner sc= new Scanner(System.in);
        disit = sc.nextInt();
        int max = 0;
        for(int i=1; i<disit+1; i++){
            int disit_num = 9;
            for(int j=1; j<i;j++)
                disit_num*=10;
            max += disit_num;
        }

        for(int i=2; i<=9; i++){
            // 소수
            if(isPrime(i)){
                findInterstingDecimal(1, i);
            }
        }


    }

    static boolean isPrime(int num){
        for(int i =2; i<=num/2; i++){
            if(num % i ==0)
                return false;
        }
        return true;
    }

    static void findInterstingDecimal(int count,int num){
        //count++;
        if(count == disit){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        }

        for(int i=1; i<=9; i++){
            if(i % 2 == 0)
                continue;
            if(isPrime(num*10 + i)){
                findInterstingDecimal(count+1, num*10 + i);
            }
        }
    }
    

}
