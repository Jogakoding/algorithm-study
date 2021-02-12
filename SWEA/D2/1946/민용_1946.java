package SWEA;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N=sc.nextInt();
			String result="";
			for(int i=0;i<N;i++) {
				String a=sc.next();
				int times=sc.nextInt();
				
				result+=new String(new char[times]).replace("\0", a);
				
			}
			System.out.println("#"+t);
			for(int i=0;i<result.length();i++) {
				System.out.print(result.charAt(i));
				if(i%10==9)System.out.println();
			}
			System.out.println();
		}
		
	}
}
