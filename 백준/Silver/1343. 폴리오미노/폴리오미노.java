import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br;
    public String  board;
    Main(){
        if(br == null){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public void run() throws Exception{
        input();
        boolean result = solution();
        print(result);
    }

    public void input() throws Exception{
        board = br.readLine();
    }

    public boolean solution(){
        board = board.replaceAll("XXXX","AAAA");
        board = board.replaceAll("XX", "BB");
        if(board.contains("X"))
            return false;
        return true;
    }

    public void print (boolean result){
        if(result){
            System.out.println(board);
        }else{
            System.out.println(-1);
        }
    }
    public static void main(String [] args) throws Exception{
        new Main().run();
    }
}
