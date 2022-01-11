N, M = list(map(int, input().split()))
target = []
targetInitial = [0 for _ in range(26)]
answer = 0

for _ in range(N):
    word = input()
    target.append(word)
    targetInitial[ord(word[0])-ord('a')] += 1

# 알파벳 순 > 길이 짧은 순
target = sorted(target, key=lambda x: (x[0], len(x)))

for idx in range(1,26): # 누적idx
    targetInitial[idx] += targetInitial[idx-1]

# print(target)
# print(targetInitial)

for _ in range(M):
    prefix = input()
    idx = int(ord(prefix[0])-ord('a'))-1
    startIdx = targetInitial[idx] #prefix 첫번째 알파벳으로 시작하는 idx 찾기
    # print(startIdx)
    while startIdx < N :
        if target[startIdx][0] == prefix[0]: #첫번째 알파벳 확인
            if target[startIdx][:len(prefix)] == prefix:
                # print(target[startIdx], " check!")
                answer += 1
                break
            else:
                startIdx += 1 #idx 1증가
        else:
            break
    
    # print(prefix, answer)


print(answer)


