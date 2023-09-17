import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int [][] matrix = new int[row][col];


        // matrix 완성
        for(int r =0; r<row; r++){
            st = new StringTokenizer(br.readLine());
            for(int c =0; c< col; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());

            }
        }

        Graph graph = new Graph(col*row, row, col, matrix);

        for(int r =0; r<row; r++){
            for(int c =0; c< col; c++){
                if( matrix[r][c] == 1){
                    graph.queue.add(new Node(col*r+c, 0));
                    graph.visited[col*r+c] = true;
                }
                if( matrix[r][c] == -1){
                    graph.visited[col*r+c] = true;
                }
            }
        }
        graph.BFS();

    }


}


class Node{
    int v;
    int count;

    Node(int v, int count){
        this.v = v;
        this.count = count;
    }
}
class Graph{
    int v;

    int row;
    int col;
    LinkedList[]  adj;

    LinkedList<Node> queue;
    boolean [] visited;
    int [][] matrix;

    int count = 0;

    Graph(int v, int row, int col, int [][] matrix){
        this.v = v;
        this.row = row;
        this.col = col;
        this.matrix = matrix;

        this.queue = new LinkedList<Node>();
        this.visited = new boolean[v+1];
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int x, int y){
        boolean isAdd = false;

        if(x+1 < row && matrix[x+1][y] != -1 ){
            int bottom = (x+1)*col + y;
            if(!visited[bottom]){
                isAdd = true;
                adj[x*col + y].add(bottom);
            }

        }
        if(x-1 >= 0 && matrix[x-1][y] != -1){
            int top = (x-1)*col + y;
            if(!visited[top]){
                isAdd = true;
                adj[x*col + y].add(top);

            }

        }

        if(y+1 < col && matrix[x][y+1] != -1){
            int left = x*col + (y+1);
            if(!visited[left]){
                isAdd = true;
                adj[x*col + y].add(left);

            }

        }

        if(y-1 >= 0 && matrix[x][y-1] != -1){
            int right = x*col + (y-1);
            if(!visited[right]){
                isAdd = true;
                adj[x*col + y].add(right);

            }

        }

//        if(isAdd){
//            count++;
//            System.out.println("count 증가 : "+ count);
//        }
    }
    boolean finish(){
        for(int i=0; i< visited.length -1; i++){
            if(!visited[i])
                return false;
        }
        return true;
    }

    void BFS()  {
        int count = 0;
        while (!queue.isEmpty()){
            Node node = (Node) queue.poll();
            addEdge(node.v/col,node.v%col);

            Iterator<Integer> iterator =  adj[node.v].iterator();
            while(iterator.hasNext()){
                int s = iterator.next();
                if(!visited[s]){
                   // System.out.println("add : "+ s/col +", "+ s%col);
                    queue.add(new Node(s,node.count +1));
                    count = node.count+1;
                    visited[s] = true;
                  //  addEdge(s/col,s%col);

                }
            }

        }
        if(finish())
            System.out.println(count);
        else{
            System.out.println(-1);
        }

    }

}

