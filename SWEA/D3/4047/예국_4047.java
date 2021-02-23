package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] S;
		boolean[] D;
		boolean[] H;
		boolean[] C;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int Scount = 13;
			int Dcount = 13;
			int Hcount = 13;
			int Ccount = 13;
			
			boolean check = true;
			
			S = new boolean[14];
			D = new boolean[14];
			H = new boolean[14];
			C = new boolean[14];
			
			String input = br.readLine();
			sb.append("#").append(testCase).append(" ");
			
			for (int i = 0; i < input.length(); i+=3) {
				String shape = String.valueOf(input.charAt(i));
				int number = Integer.parseInt(String.valueOf(input.substring(i+1, i+3)));
				if(shape.equals("S")) {
					if(S[number]) {
						sb.append("ERROR");
						check = false;
						break;
					}else {
						S[number] = true;
						Scount--;
					}
				}
				else if(shape.equals("D")) {
					if(D[number]) {
						sb.append("ERROR");
						check = false;
						break;
					}else {
						D[number] = true;
						Dcount--;
					}
				}
				else if(shape.equals("H")) {
					if(H[number]) {
						sb.append("ERROR");
						check = false;
						break;
					}else {
						H[number] = true;
						Hcount--;
					}
				}
				else {
					if(C[number]) {
						sb.append("ERROR");
						check = false;
						break;
					}else {
						C[number] = true;
						Ccount--;
					}
				}
			}
			
			if(check)
				sb.append(Scount).append(" ").append(Dcount).append(" ").append(Hcount).append(" ").append(Ccount);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
