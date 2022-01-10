package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1543_20220110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String q=br.readLine();
		String find=br.readLine();
		int size=find.length();
		int cnt=0;
		q=q.replace(find, "#");
		
		for(int i=0;i<q.length();i++) {
			if(q.charAt(i)=='#') {
				cnt++;
			}
		}
		System.out.println(cnt);
		
			
	}
}
