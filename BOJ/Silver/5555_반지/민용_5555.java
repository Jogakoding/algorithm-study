package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B22020119_5555 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		for(int i=0;i<n;i++) {
			String temp=br.readLine();
			temp=temp+temp+temp;
			if(temp.indexOf(s)!=-1) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
