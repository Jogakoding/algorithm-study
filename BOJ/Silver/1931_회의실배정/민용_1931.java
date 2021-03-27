package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1931_회의실배정 {
	static class time implements Comparable<time>{
		int start,end;
		public time(int start,int end) {
			this.start=start;
			this.end=end;
		}
		
		
		//만약 종료시간이 같다면, 시작시간이 더 빠른 것으로 한다.
		@Override
		public int compareTo(time o) {
			if(this.end==o.end) {
				return this.start-o.start;
			}
			return this.end-o.end;
		}
		
		public String toString() {
			return this.start+" "+this.end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		time arr[]=new time[n];
		for(int i=0;i<n;i++) {
			String[]str =br.readLine().split(" ");
			arr[i]=new time(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
		}
		
		//정렬
		Arrays.sort(arr);
		
		//정렬결과를 바탕으로 순회시작.
		//직전회의 종료시간이 다음의 회의 시작시간과 "같거나" 같을 때
		//end라는 변수에 다음 회의의 종료시간을 넣어준다.
		int cnt=0;
		int end=-1;
		for(int i=0;i<n;i++) {
			if(arr[i].start>=end) {
				end=arr[i].end;
				cnt++;
				System.out.println(arr[i].start+" "+arr[i].end);
			}
		}
		System.out.println(cnt);
		
	}
}
