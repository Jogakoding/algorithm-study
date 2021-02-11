T = int(input())

for testCase in range(1, T + 1):
    num = int(input())
    move = [0,0]
    
    for _ in range(num):
        a = list(map(int, input().split()))

        if a[0] == 1:
            move[0] += a[1]
        elif a[0] == 2:
            move[0] -= a[1] if move[0]>=a[1] else move[0]
        move[1] += move[0]
    print(f'#{testCase} {move[1]}')
        
