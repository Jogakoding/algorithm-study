package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15686 {

	private static int[][] houseList;
	private static int houseIdx;
	private static int[][] chickenList;
	private static int chickIdx;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] road = new int[N][N];
		houseList = new int[2*N][2*N];
		houseIdx = 0;
		chickenList = new int[13][13];
		chickIdx = 0;
		for (int i = 0; i < 2*N; i++) {
			Arrays.fill(houseList[i], -1);
		}
		for (int i = 0; i < 13; i++) {
			Arrays.fill(chickenList[i], -1);
		}
		
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
				
				if(road[i][j]==2) {// 치킨집
					chickenList[chickIdx][0] = i;
					chickenList[chickIdx++][1] = j;					
				}else if(road[i][j]==1) { //집
					houseList[houseIdx][0] = i;
					houseList[houseIdx++][1] = j;		
				}
			}
		}
		
		getCombi(M, 0, 0, 0);
		System.out.println(answer);
		
	}
	
	private static void getCombi(int M, int idx, int count, int flag) {
		//System.out.println("idx="+idx+" count"+count+" "+Integer.toBinaryString(flag));
		
		if(count==M) {
			updateAnswer(flag);
			return;
		}else if(idx>chickIdx)
			return;
		
		if(idx<chickIdx)
			getCombi(M, idx+1, count+1, flag | 1<<idx);
		getCombi(M, idx+1, count, flag);
		
	}

	private static void updateAnswer(int flag) {
		int tempAnswer = 0;
		
		//System.out.println(Integer.toBinaryString(flag));
		
		for (int i = 0; i < houseIdx; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j<chickIdx; j++) {
				int compare = Math.abs(chickenList[j][0]-houseList[i][0]) + Math.abs(chickenList[j][1]-houseList[i][1]);
				if((1<<j & flag)!=0 && min > compare) { //선택되었다면
					min = compare;
				}
			}
			//System.out.println(i+"th house > "+min);
			tempAnswer += min;
		}
		
		//System.out.println(flag+" >> "+tempAnswer);
		
		if(tempAnswer>0)
			answer = answer > tempAnswer? tempAnswer : answer;
		
	}

}
