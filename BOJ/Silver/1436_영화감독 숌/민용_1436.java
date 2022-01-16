package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; 

public class BOJ1436_20220116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int cnt=0;
		int i=0;
		while(true) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
				if(cnt==n) {
					break;
				}
			}
			i++;
		}
		System.out.println(i);
				
	}
}
