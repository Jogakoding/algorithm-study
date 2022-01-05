def solution(answers):
    patterns = [[1, 2, 3, 4, 5],
                [2, 1, 2, 3, 2, 4, 2, 5],
                [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    counts = [[5, 0], [8, 0], [10, 0]]

    for i in range(len(answers)):
        for j in range(3):
            if answers[i] == patterns[j][i%counts[j][0]]:
                counts[j][1] += 1

    max_cnt = max(list(zip(*counts))[1])
    answer = [i+1 for i in range(3) if counts[i][1] == max_cnt]
    return answer