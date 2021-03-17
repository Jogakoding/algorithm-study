import sys
sys.stdin = open('9205_input.txt', 'r')

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    # home + beer
    beer = [list(map(int, input().split())) for _ in range(N+1)]
    # festival x, festival y
    fx, fy = map(int, input().split())

    visited = [0 for _ in range(N+1)]
    queue = [0]

    # queue에 있는걸 뽑으면서,
    # 1. fx, fy랑 거리가 1000이하면 그 즉시 종료
    # 2. 아니면 방문하지 않은 것들중에서 거리가 1000 이하인 맥주샵들 전부 추가
    while queue:
        c = queue.pop()
        visited[c] = 1
        cx, cy = beer[c][0], beer[c][1]

        if (abs(fx-cx) + abs(fy-cy)) <= 1000:
            mood = 'happy'
            break

        for i in range(N+1):
            bx, by = beer[i][0], beer[i][1]
            if not visited[i] and (abs(bx-cx) + abs(by-cy)) <= 1000:
                queue.append(i)
    else:
        mood = 'sad'
    print(mood)