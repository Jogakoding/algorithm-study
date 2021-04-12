import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	private static int[] simsa;
	private static long M;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		simsa = new int[N];
		
		for (int i = 0; i < N; i++) {
			simsa[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(simsa);
		
		System.out.println(findAnswer(0,simsa[0] * M));
	}

	private static long findAnswer(long start, long end) {
		if(start>=end) return start;
		
		long mid = (start+end)/2;
		long cnt = 0;
		
		for (int i : simsa) {
			cnt += mid/i;
		}
		
		if(cnt>=M)	return findAnswer(start, mid);
		else		return findAnswer(mid+1, end);

	}

}
