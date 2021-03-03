T = int(input())

for tc in range(1, T+1):
    lines = []
    ans = 0

    N = int(input())

    for _ in range(N):
        s1, e1 = map(int, input().split())
        for s2, e2 in lines:
            # 시작점과 끝점 중 하나는 높고, 하나는 낮아야지만 겹치는 점이 생긴다는 것을 이용
            if (s1 > s2) ^ (e1 > e2):
                ans += 1
        lines.append([s1, e1])
    print("#%d %d" % (tc, ans))