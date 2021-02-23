import sys
sys.stdin = open('input.txt', 'r')

T = int(input())
for tc in range(1, T+1):
    N, income = int(input()), list(map(int, input().split()))
  
    avg = sum(income)/len(income)
    cnt = 0
    for i in income:
        if i <= avg:
            cnt += 1
    print("#%d %d" % (tc, cnt))
