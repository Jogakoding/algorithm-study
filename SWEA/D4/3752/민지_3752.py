import sys
sys.stdin = open('3752_input.txt', 'r')

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    i = 0

    scores = list(map(int, input().split()))
    result = set(scores)
    result.add(0)
    # 이때까지 더한 숫자들 중 가장 높은 인덱스를 가진 숫자의 인덱스와, 이때까지의 합을 배열로 저장한다
    sum_lst = list(map(list, enumerate(scores)))
    for _ in range(N-1):
        temp = []
        for lst in sum_lst:
            if lst[0] <= N-2:
                for i in range(lst[0]+1, N):
                    score = lst[1] + scores[i]
                    result.add(score)
                    temp.append([i, lst[1]+scores[i]])
        sum_lst = temp

    print("#%d %d" % (tc, len(result)))

# for tc in range(1, T+1):
#     N = int(input())
#     problems = list(map(int, input().split()))
#     scores = set()
#     for i in range(1 << N):
#         score = 0
#         for j in range(N):
#             if i & (1 << j):
#                 score += problems[j]
#         scores.add(score)
#     print("#%d %d" % (tc, len(scores)))

                