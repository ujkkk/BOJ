
import java.io.*;
import java.util.*;


class Main
{
    public static HashSet<Character> set;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        HashSet<String> names = new HashSet<>();
        for(int i=0; i<N; i++){
            names.add(br.readLine());
        }

        List<String> nameList = new ArrayList<>();
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(names.contains(name)){
                nameList.add(name);
            }
        }
        nameList.sort(Comparator.naturalOrder());

        bw.write(nameList.size() + "\n");
        nameList.forEach(name -> {
            try {
                bw.write(name+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();

        bw.close();
        br.close();

    }

}

