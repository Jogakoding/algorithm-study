T = int(input())

dates = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for testCase in range(1, T + 1):
    s1,e1,s2,e2 = list(map(int, input().split()))
    # answer = sum(dates[:s2-1]) + e2 - sum(dates[:s1-1]) - e1 + 1
    answer = 0
    for month in range(s1+1,s2):
        answer += dates[month]
    if s1 != s2:
        answer += dates[s1] - e1 + 1 + e2
    else:
        answer += e2 - e1 + 1

    print(f'#{testCase} {answer}')
