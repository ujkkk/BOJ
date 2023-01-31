import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Integer [] arr = new Integer[N];
		for(int i=0; i< N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		for(int i = N-1; i >=0 ; i--) {
			int chage = 0;
			for(int j=0; j<i; j++) {
				if(arr[j]> arr[j+1]) {
					chage++;
					int tem = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= tem;
				}
			}
			if(chage == 0) break;
		}
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}

	}

}
