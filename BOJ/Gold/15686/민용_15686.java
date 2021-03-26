package com.ssafy;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_15686_치킨배달 {
	static int n, m;
	static int arr[][];

	static class pos implements Comparable<pos> {
		int y, x;
		int cnt = 0;

		public pos(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(pos o) {
			// TODO Auto-generated method stub
			return o.cnt - this.cnt;
		}

	}

	static ArrayList<pos> list;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map;
	static int[] distance;
	static HashMap<Integer, Integer> hash;
	static HashMap<Integer, Integer> hash2;
	static ArrayList<pos> chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		chicken = new ArrayList<>();
		arr = new int[n][n];
		map = new int[n][n];
		hash = new HashMap();
		hash2 = new HashMap();
		list = new ArrayList();
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if (arr[i][j] == 1) {
					// 집 좌표 저장
					list.add(new pos(i, j));
				}
				if (arr[i][j] == 2) {
					// 치킨집좌표 저장
					hash.put(i * n + j, 0);
					hash2.put(i * n + j, 0);
					chicken.add(new pos(i, j));
				}
			}
		}
		distance = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			bfs(list.get(i), i);
		}
		int answer = 0;
		// 해쉬맵 정렬..Arrays.sort(hash);
//		System.out.println(answer);
//		System.out.println(hash);
//		System.out.println(hash2);
		ArrayList<Integer> keySetList = new ArrayList<>(hash.keySet());
		Collections.sort(keySetList, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));
		ArrayList<Integer> keySetList2 = new ArrayList<>(hash2.keySet());
		Collections.sort(keySetList2, (o1, o2) -> (hash2.get(o2).compareTo(hash2.get(o1))));
//		System.out.println(keySetList);
//		System.out.println(keySetList2);
		int sum=0;
		for(int i=0;i<m;i++) {
			int val=hash2.get(keySetList.get(i));
			sum+=val;
		}
		System.out.println(sum);
	}
	/*
	 * 내 머리속 로직 1. 입력 받을 때, 집의 pos (1의 좌표)를 list에 넣음 2. 각 집 기준으로 bfs로 가장 가까운 치킨집(2의
	 * 좌표)를 찾음 3. 해당 좌표의 cnt를 증가시킴. 해당 치킨집과 집사이의 치킨거리를 구해서 저장. 4. cnt를 기준으로 정렬시킨다.
	 * 5. 상위 M개만 남기고, 그 치킨거리의 합을 출력한다.
	 * 
	 * 
	 */

	private static void bfs(pos p, int idx) {

		Queue<pos> q = new LinkedList<>();
		int chickenY = p.y;
		int chickenX = p.x;
		q.offer(p);
		boolean[][] visit = new boolean[n][n];
		while (!q.isEmpty()) {
			pos tempPos = q.poll();
			int y = tempPos.y;
			int x = tempPos.x;
			visit[y][x] = true;

			// 치킨집에서 가까운 치킨집을 찾았을 경우
			if (arr[y][x] == 2) {
				distance[idx] = Math.abs(chickenY - y) + Math.abs(chickenX - x);
				int tempo = hash.get(y * n + x);
				hash.put(y * n + x, tempo + 1);
				int tempdist = hash2.get(y * n + x);
				hash2.put(y * n + x, tempdist + distance[idx]);
				// 해쉬 값 업데이트
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.offer(new pos(ny, nx));
				}
			}

		}

	}
}
