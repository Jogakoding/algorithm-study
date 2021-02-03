package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test_case=Integer.parseInt(br.readLine());
		
		for(int T=0;T<test_case;T++) {
			
			String[] temp=br.readLine().split(" ");
			int n=Integer.parseInt(temp[0]);
			int m=Integer.parseInt(temp[1]);
			int[][] arr=new int[n][n];
			
			
			
			
			
			for(int i=0;i<n;i++) {
				String[] str=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			
			
			
			
			int max=-1;
			for(int i=0;i<=n-m;i++) {
				for(int j=0;j<=n-m;j++) {
					int sum=0;
					for(int k=0;k<m;k++) {
						for(int l=0;l<m;l++) {
							sum+=arr[i+k][j+l];
						}
					}
					if(sum>max)max=sum;
				}
			}
			
			System.out.println("#"+(T+1)+" "+max);
		}
	}
}
