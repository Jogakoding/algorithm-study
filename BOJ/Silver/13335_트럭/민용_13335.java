import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		int l = Integer.parseInt(str[2]);
		int[] arr = new int[n];
		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		Queue<Integer> q = new LinkedList<>();
		int weight = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			while (true) {

				// queue가 비어있다 = 다리가 비어있음. 그 다음 트럭을 넣는다.
				if (q.isEmpty()) {
					time++;
					q.offer(arr[i]);
					weight += arr[i];
					break;
                    // q사이즈가 길이와 같다 = 꽉 찼다.
                    // = 하나를 빼준다.
				} else if (q.size() == w) {
					weight -= q.poll();
				} else {
                    // 다리가 꽉차지도 앟았고 텅 비어있지도 않을때.
                    // 새로 들어갈 트럭의 무게의 합이 최대 하중보다 크다면
                    // 0을 넣어준다.(더 들어갈 수 없다는 뜻)
					if (weight + arr[i] > l) {
						q.offer(0);
						time++;
					}else {
                        //더 들어갈 수 있다면 다음 트럭을 넣어준다.
						q.offer(arr[i]);
						time++;
						weight+=arr[i];
						break;
					}
				}


			}
		}
        // 지금까지 소모한 시간 + 마지막 트럭이 건너는시간(=다리의 길이)
		System.out.println(time+w);

	}
}
