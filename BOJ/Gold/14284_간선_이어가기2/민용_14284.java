package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_14284_간선이어가기2 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		ArrayList<int[]>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			int src = Integer.parseInt(temp[0]);
			int dest = Integer.parseInt(temp[1]);
			int score = Integer.parseInt(temp[2]);
			list[src].add(new int[] { dest, score });
			list[dest].add(new int[] { src, score });
		}
		String[] temp = br.readLine().split(" ");
		int src = Integer.parseInt(temp[0]);
		int dest = Integer.parseInt(temp[1]);

		boolean visit[] = new boolean[n + 1];
		int[] cnt = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			cnt[i] = Integer.MAX_VALUE;
		}
		cnt[src] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
//		Queue<Integer> pq = new LinkedList();
		pq.offer(new int[] {src,0});

		while (!pq.isEmpty()) {
			int now[] = pq.poll();
			int nowScore = cnt[now[0]];
			if (now[0] == dest) {
				System.out.println(nowScore);
				return;
			}
			if (visit[now[0]])
				continue;
			visit[now[0]] = true;
			// 종료조건?

			for (int i[] : list[now[0]]) {

				int des = i[0];
				int sco = i[1];
				if (!visit[des]) {
					pq.offer(new int[] {des,nowScore+sco});
					cnt[des] = Math.min(cnt[des], nowScore + sco);
				}

			}

		}
//		System.out.println(Arrays.toString(cnt));

	}

}
