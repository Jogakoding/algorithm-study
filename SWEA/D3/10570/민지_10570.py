import sys
sys.stdin = open('input.txt', 'r')

T = int(input())

for tc in range(1, T+1):
    a, b = map(int, input().split())

    cnt = 0
    for i in range(a, b+1):
        # 일단 제곱수인지 아닌지 판단하기 (제곱수가 아니라면 팰린드롬도 아니기 때문)
        if i**(1/2) != int(i**(1/2)):
            continue
        
        # i 와 i의 제곱수 j를 str으로 변환
        j = str(int(i**(1/2)))  
        i = str(i)
        # 팰린드롬인지 판별
        if i == i[::-1] and j == j[::-1]:
            cnt += 1
    
    print("#%d %d" % (tc, cnt))

