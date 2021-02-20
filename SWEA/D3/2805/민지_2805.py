import sys
sys.stdin = open('2805_input.txt', 'r')

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    farm = []

    for _ in range(N):
        row = []
        num = input()
        row.extend(num)
        farm.append(list(map(int, row)))
    
    mid = len(farm)//2
    total = sum(farm[mid])
    for i in range(mid):
        total += sum(farm[i][mid-i:mid+i+1]) + sum(farm[len(farm)-1-i][mid-i:mid+i+1])
    
    print("#%d %d" % (tc, total))