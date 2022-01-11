N = int(input())

wordList = set() #중복제거용

for _ in range(N):
    word = input()
    wordList.add(word)

wordList = sorted(wordList, key=lambda x : (len(x), x))

for x in wordList:
    print(x)