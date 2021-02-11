T = int(input())

for test_case in range(1, T + 1):
    p, q, r, s, w = list(map(int, input().split()))

    a = p * w
    b = q + (w-r)*s if w>r else q

    print(f'#{test_case} {min(a, b)}')