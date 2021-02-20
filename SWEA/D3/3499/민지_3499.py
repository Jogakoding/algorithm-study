import sys
sys.stdin = open('3499_input.txt')

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = list(input().split())

    # 덱이 나눠지는 포인트
    mid = N//2+1 if N % 2 else N//2 # 뒤 절반의 인덱스
    
    result = [0] * len(arr)

    i = 0
    j = 0
    for num in arr[0:mid]:
        result[i*2] = num
        i += 1
    
    for num in arr[mid:]:
        result[j*2+1] = num
        j += 1
    
    print("#%d %s" % (tc, " ".join(result)))