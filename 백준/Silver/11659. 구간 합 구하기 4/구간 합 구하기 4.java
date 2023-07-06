import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //데이터의 개수
		int M =  sc.nextInt(); //총 몇번 실행
		
		long num[] = new long[N];
		for(int k=0; k<N; k++)
			num[k] = sc.nextLong();
		
		int [] i = new int[M];
		int [] j = new int[M];
		
		for(int k=0; k<i.length; k++) {
			i[k] = sc.nextInt();
			j[k] = sc.nextInt();
		}
		
		//구간 합 구하기
		long [] sum = new long[N];
		sum[0] = num[0];
		for(int k=1; k< sum.length; k++) {
			sum[k] = sum[k-1] + num[k];
		}
		
		//특정 i,j의 구간합 구하기
		long result[] = new long[M];
		for(int k=0; k< result.length; k++) {
			if(i[k] ==1) 
				result[k] = sum[j[k]-1];
			else
				result[k] = sum[j[k]-1] - sum[i[k]-2];
			System.out.println(result[k]);
		}
		

		
	}

}
