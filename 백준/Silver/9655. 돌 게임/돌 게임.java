import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int i;
        boolean isSK = true;
        for(i = 1; i< N-3; i+=3){
            isSK = !isSK;
        }
        while(i != N){
            i++;
            isSK = !isSK;
        }

        if(isSK){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}
