T = int(input())

for testCase in range(1, T +1):
    num = int(input())
    s = ''
    for _ in range(num):
        alpha, count = list(map(str,input().split()))
        s += alpha*int(count)

    print(f'#{testCase}')
    for i in range(int(len(s)/10)+1):
        print(s[i*10:i*10+10])