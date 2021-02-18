package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_10761 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			
			String[] order = new String[cnt];
			Queue<Integer> bList= new LinkedList<Integer>();
			Queue<Integer> oList= new LinkedList<Integer>();
			int idx = 0;
			while(st.hasMoreTokens()) {
				String robot = st.nextToken();
				int button = Integer.parseInt(st.nextToken());
				order[idx++] = robot;
				if(robot.equals("B")) {
					bList.add(button);
				}else {
					oList.add(button);
				}
			}
			
			int answer = -1;
			idx = 0;
			int bLoc = 0;
			int oLoc = 0;
			
			while(idx < cnt) {
				answer++;
				String doing = order[idx];
				int bTarget =  bList.peek()==null?bLoc:bList.peek();
				int oTarget =  oList.peek()==null?oLoc:oList.peek();
				
				if(doing.equals("B") && bLoc==bTarget) {
					bList.poll();
					idx++;
				}else if(bLoc < bTarget) {
					bLoc++;
				}else if(bLoc > bTarget){
					bLoc--;
				}
				
				if(doing.equals("O") && oLoc==oTarget) {
					oList.poll();
					idx++;
				}else if(oLoc < oTarget){
					oLoc++;
				}else if(oLoc > oTarget){
					oLoc--;
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
