import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    static ArrayList<Integer>[] A;
    static boolean [] visited;
    static boolean result = false;
    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int e = Integer.parseInt(st.nextToken()); // 간선의 수

        A = new  ArrayList[n];
        visited = new boolean [n];

        // node
        for(int i=0; i<n; i++){
            A[i] = new ArrayList<Integer>();
        }

        // edge
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 관계 추가
            A[u].add(v);
            A[v].add(u);
        }

        int count = 1;
        for(int i=0; i<n; i++){
            DFS(i, 1);
            if(result)
                break;
        }

       // DFS(0, 1);
        if(result){
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }

    }

    static void DFS(int v, int count){
       // System.out.println(count);
        if(count == 5 || result){
            result = true;
            return;
        }

        if(visited[v])
            return;

        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i, count+1);
            }

        }
        visited[v] = false;

    }




}
