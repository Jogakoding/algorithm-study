package SWEA;

import java.util.Scanner;

public class SWEA_1948_날짜계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] days= {31,28,31,30,31,30,31,31,30,31,30,31};
		int N=sc.nextInt();
		for(int t=1;t<=N;t++) {
			int m1=sc.nextInt();
			int d1=sc.nextInt();
			int m2=sc.nextInt();
			int d2=sc.nextInt();
			
			int diff=d2-d1+1;
			for(int i=m1;i<m2;i++)diff+=days[i-1];//각 월(인덱스 0부터시작했으므로)의 일수를 더해줌
			System.out.println("#"+t+" "+diff);
			
		}
	}
}
