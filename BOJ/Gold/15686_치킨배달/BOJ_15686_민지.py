import sys
from itertools import combinations

sys.stdin = open('15686_input.txt', 'r')

"""
BOJ 15686 치킨 배달: 풀이 방법
1. 치킨 거리를 표시할 배열을 하나 만든다(chicken_dist)
2. 매 칸을 탐색하면서 집(==1)이면 집에서 가장 가까운 치킨집을 찾는다
3. chicken_dist[가까운_치킨집_좌표]에 치킨 거리만큼을 더한다
4. 탐색이 끝난 후 chicken_dist 치킨거리가 가장 낮은 M개의 프랜차이즈만 찾아 합을 구한다
"""
drc = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def find_chicken_dist(sr, sc):
    # bfs 구현
    visited = [[0]*(N+2) for _ in range(N+2)]
    # queue에는 현재의 cr, cc, dist(현재칸까지의 거리)를 list로 저장
    queue = [[sr, sc, 0]]
    visited[sr][sc] = 1
    while queue:
        cr, cc, dist = queue.pop(0)
        for dr, dc in drc:
            nr, nc = cr+dr, cc+dc
            if town[nr][nc] == 2:
                return dist+1
            
            if not visited[nr][nc] and town[nr][nc] != -1:
                visited[nr][nc] = 1
                queue.append([nr, nc, dist+1])
            


N, M = map(int, input().split())
town = [[-1] + list(map(int, input().split())) + [-1] for _ in range(N)]
town.insert(0, [-1]*(N+2))
town.append([-1]*(N+2))

# 치킨집의 좌표를 모아놓은 리스트
chicken = []
for i in range(1, N+1):
    for j in range(1, N+1):
        if town[i][j]==2:
            chicken.append([i, j])
            town[i][j] = 0

arr = combinations(chicken,  M)


# 최소 거리 찾기
min_dist = 1000000
flag = 0
for combi in arr:
    for i in combi:
        town[i[0]][i[1]] = 2

    dist = 0
    for i in range(1, N+1):
        for j in range(1, N+1):
            if town[i][j] == 1:
                dist += find_chicken_dist(i, j)
                if dist >= min_dist:
                    flag = 1
                    break
        if flag:
            flag = 0
            for i in combi:
                town[i[0]][i[1]] = 0
            break

    for i in combi:
        town[i[0]][i[1]] = 0

    if dist < min_dist:
        min_dist = dist
                
print(min_dist)
