package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * int[] arr=new int[11]; for(int i=1;i<11;i++) { int number=i;
		 * if(i%2==0)number*=-1; arr[i]=number+arr[i-1]; }
		 * 
		 * 
		 * int num=Integer.parseInt(br.readLine()); for(int i=1;i<=num;i++) { int
		 * N=Integer.parseInt(br.readLine()); System.out.println("#"+i+" "+arr[N]); }
		 */

		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			int tar = Integer.parseInt(br.readLine());
			if (i % 2 == 0)
				System.out.println(tar / 2 * (-1));
			else {
				System.out.println((tar + 1) / 2);
			}
		}
	}
}
