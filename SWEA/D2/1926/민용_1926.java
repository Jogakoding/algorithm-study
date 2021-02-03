package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_1926 {

	public static void main(String[] args) throws IOException {
		/*
		 * Scanner sc=new Scanner(System.in);
		 * 
		 * int n=sc.nextInt();
		 * 
		 * for(int i=1;i<=n;i++) {
		 * 
		 * if(i<10) { if(i%3==0) { System.out.print("-"+" "); }else {
		 * System.out.print(i+" "); }
		 * 
		 * }else if(i<100) { String str=""; if( (i/10)%3==0 ) { str+="-"; }
		 * 
		 * if( (i%10)!=0 && (i%10)%3==0 ) { str+="-"; }
		 * 
		 * if(str.length()!=0) { System.out.print(str+" "); }else {
		 * System.out.print(i+" "); }
		 * 
		 * 
		 * }else { int a,b,c; int cnt=0; a=i/100; b=(i/10)%10; c=i%10;
		 * if(c%3==0&&(i%10)!=0)cnt++; if(b%3==0&&(i/10)%10!=0)cnt++; if(a%3==0)cnt++;
		 * 
		 * if(cnt==0) { System.out.print(i+" "); }else { String str=""; for(int
		 * k=0;k<cnt;k++) { str+="-"; } System.out.print(str+" "); }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N =br.readLine();
		for (int i = 1; i <=  Integer.parseInt(N); i++) {
			int sum=0;
			char[] s=Integer.toString(i).toCharArray();
			for(int m=0;m<s.length;m++) {
				if(s[m]=='3'||s[m]=='6'||s[m]=='9') {
					sum++;
				}
			}
			if(sum!=0) {
				for(int k=0;k<sum;k++) {
					System.out.print("-");
				}
			}else {
				System.out.print(i);
			}
			System.out.print(" ");

		}
	}
}
