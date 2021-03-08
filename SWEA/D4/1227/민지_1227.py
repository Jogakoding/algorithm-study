# 델타 (상하좌우 순으로)
drc = [[-1, 0], [1, 0], [0, -1], [0, 1]]

# 2 --> 3을 찾던 3 --> 2를 찾던 상관없기 때문에 위에서 부터 탐색하기 위해 3 --> 2로 가는 경로 탐색
# ans의 값은 갈 수 없는 길을 찾았을때 0, 갈 수 있는 길을 찾았을때 1
def find_path(maze, sr, sc):
    # 방문한 노드를 표시할 matrix 만들기
    visited = [[0]*(N+2) for _ in range(N+2)]
    # queue 만들기
    queue = [[sr, sc]]
    while queue:
        cr, cc = queue.pop()
        visited[cr][cc] = 1
        for dr, dc in drc:
            # 도착 점인지 체크
            # 탐색 도중이라도, 갈 수 있는 길을 하나라도 찾았다면, 더이상 탐색할 필요가 없으므로 ans == 1일때는 for loop 탈출 
            if maze[cr+dr][cc+dc] == 3:
                return 1
            # 현재 위치 기준으로 상하좌우중 탐색하지 않은 노드가 있다면, 재귀 함수를 호출하여 다음 노드 탐색
            if maze[cr+dr][cc+dc]==0 and not visited[cr+dr][cc+dc]:
                queue.append([cr+dr, cc+dc])
    return 0


for _ in range(10):
    tc = int(input())
    N = 100
    
    # maze 입력 받기 + 시작 좌표 찾기
    maze = []
    for i in range(N):
        temp = list(map(int, input()))
        for j in range(N):
            if temp[j] == 2:
                sr, sc = i, j
        maze.append(temp)

    res = find_path(maze, sr, sc)
    print("#%d %d" % (tc, res))
