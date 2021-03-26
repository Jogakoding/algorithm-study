package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_개리맨더링 {
	static int n,min=Integer.MAX_VALUE;
	static int[] population;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		//입력 
		// population : 각 인덱스에 해당하는 도시의 인구수
		// list : 인접하는 도시들의 정보를 어레이리스트에 입력
		// visit : A,B 두 도시로 나누기 위해서 A도시는 true, B도시는 false로 구분
		population = new int[n + 1];
		boolean[] visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 도시의 인덱스가 1부터 시작이므로 1로부터 부분집합을 형성한다.
		// 만약 최소값에 변화가 없다면 -1을 출력해준다.
		// 실행순서
		// 1. 부분집합 구하기
		// 2. 각 부분집합들이 연결되어있는지 확인(bfs)
		// 3. 연결되어있는 경우, 연결하면서 더했던 각 집단끼리의 합의 차이를 구해서 return
		powerset(1, visit);
		if(min==Integer.MAX_VALUE)min=-1;
		System.out.println(min);
	}
	
	private static void powerset(int select, boolean[] visit) {
		if (select == n + 1) {
			
			// flagA,flagB는 bfs를 시작하기 위한 지점이다.
			// visit[i]=true이면 flagA의 시작점, 아니면 flagB의 시작점이다.
			int flagA=-1;
			int flagB=-1;
			
			for (int i = 1; i <= n; i++) {
				if (visit[i]) {
					flagA=i;
					break;
				}
			}
			
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {
					flagB=i;
					break;
				}
			}
			
			// 만약 둘 중 하나라도 flag의 값이 변화가 없다면,
			// 모두 한 집단에 속한다는 것을 의미하므로 유의미한 부분집합이 아니므로 return
			if(flagA==-1||flagB==-1) {
				return;
			}
			
			// A집단, B집단에 대해서 BFS를 수행한다.
			Queue<Integer> q=new LinkedList<>();
			q.offer(flagA);
			
			boolean[] checked=new boolean[n+1];
			
			//flagA -> A집단의 시작점.여기서 A집단 모두가 연결되어야함
			checked[flagA]=true;
			int sumA=0,sumB=0;
			while(!q.isEmpty()) {
				
				int num=q.poll();
				sumA+=population[num];
				
				for(int i=0;i<list[num].size();i++) {
					
					//큐에서 뺀 숫자의 인접리스트들 = 인접하는 도시의 번호들
					int adjNum=list[num].get(i);
					
					// visit[adjNum]가 true -> A집단인지 확인. B집단이면 BFS하면 안됨.
					// check[adjNum]이 방문한 곳인지 확인
					if(visit[adjNum]&&!checked[adjNum]) {
						checked[adjNum]=true;
						q.offer(adjNum);
					}
					
				}
			}
			
			q.offer(flagB);
			checked[flagB]=true;
			while(!q.isEmpty()) {
				
				int num=q.poll();
				sumB+=population[num];
				for(int i=0;i<list[num].size();i++) {
					
					//큐에서 뺀 숫자의 인접리스트들 = 인접하는 숫자들
					int adjNum=list[num].get(i);
					
					// visit[adjNum]가 falses -> B집단인지 확인. B집단이면 BFS하면 안됨.
					// check[adjNum]이 방문한 곳인지 확인
					if(!visit[adjNum]&&!checked[adjNum]) {
						checked[adjNum]=true;
						q.offer(adjNum);
					}
					
				}
			}
			
			for(int i=1;i<=n;i++) {
				if(!checked[i]) {
					return;
				}
			}
			
			
			min=Math.min(min, Math.abs(sumA-sumB));
			
			
			return;
		}

		visit[select] = true;
		powerset(select + 1, visit);
		visit[select] = false;
		powerset(select + 1, visit);

	}
	
}
