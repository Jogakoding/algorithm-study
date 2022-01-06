def fibonacci(n):
    global cnt_0, cnt_1
    if n == 0:
        cnt_0 += 1
        return 0
    elif n == 1:
        cnt_1 += 1
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)

N = int(input())
for i in range(N):
    cnt_0 = cnt_1 = 0
    n = int(input())
    fibonacci(n)
    print(cnt_0, cnt_1)
