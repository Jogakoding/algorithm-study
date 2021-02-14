package SWEA;

import java.util.Base64;
import java.util.Scanner;

public class SWEA_1928_Base64 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int t=1;t<=N;t++) {
			String str=sc.next();
			String answer=new String(Base64.getDecoder().decode(str));
			System.out.println("#"+t+" "+answer);
		}
	}
}
