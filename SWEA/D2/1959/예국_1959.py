T = int(input())

for testCase in range(1, T + 1 ):
    x, y = list(map(int, input().split()))
    sum = 0
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    if x > y:
        for i in range(x-y+1):
            temp = 0
            for a_val, b_val in zip(a[i:],b):
                temp += a_val * b_val
            sum = sum if sum > temp else temp
    else:
        for i in range(y-x+1):
            temp = 0
            for b_val, a_val in zip(b[i:],a):
                temp += a_val * b_val
            sum = sum if sum > temp else temp

    print(f'#{testCase} {sum}')
    