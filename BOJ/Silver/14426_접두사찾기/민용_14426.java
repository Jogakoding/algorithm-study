package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ14426_20220112 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] arr=br.readLine().split(" ");
		int n=Integer.parseInt(arr[0]);
		int m=Integer.parseInt(arr[1]);
		
		String[] listArr=new String[n];
		String[] findArr=new String[m]; 
		for(int i=0;i<n;i++) {
			listArr[i]=br.readLine();
		}
		for(int i=0;i<m;i++) {
			findArr[i]=br.readLine();
		}
		int cnt=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(listArr[j].indexOf(findArr[i])==0) {
					cnt++;
					break;
				}
			}
			
		}
		System.out.println(cnt);		
		
		
		
			
	}
}
