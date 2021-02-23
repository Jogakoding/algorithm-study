package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;


public class SWEA_10200 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// sys.stdin = open('input.txt', r)랑 같은 코드
		System.setIn(new FileInputStream("input.txt"));
    // 인풋 전체 읽어오기
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		// parseint = int()
    // readLine = 한줄씩 읽어오기
    int n=Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<n;tc++) {
      // 이거 뭔가 .split같은 느낌인데 잘 모르겠움!!
			StringTokenizer st=new StringTokenizer(br.readLine());
			// .nextToken = st에서 다음 토큰 (다음 아이템) 가져오기
      int total=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			int max=Math.min(a, b);
      // min값 0으로 초기화
			int min=0;
			int both=a+b;
      // a+b가 total 보다 작으면 min은 무조건 0이므로 바꿀필요 없음
			if (both>total) {
				min=both-total;
			}
			System.out.println("#"+tc+" "+max+" "+min);				
		}
	}

}