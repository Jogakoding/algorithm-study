T = int(input())

for testCase in range(1, T + 1):
    num = int(input())

    m = [[0]*num for _ in range(num)]

    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    x,y = 0, 0 
    direction = 0
    number = 1
    while(number < num**2):
        m[x][y] = str(number)
        if 0 <= x+dx[direction] < num and 0 <= y+dy[direction] < num:
            if not m[x+dx[direction]][y+dy[direction]]:
                x = x+dx[direction]
                y = y+dy[direction]
                number += 1
            else:
                direction = (direction+1) % 4
        else:
            direction = (direction+1) % 4
    m[x][y] = str(number)
    print(f'#{testCase}')
    for row in m:
        print(' '.join(row))