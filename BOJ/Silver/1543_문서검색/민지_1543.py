document = input()
word = input()
D, W = len(document), len(word)
i = 0
cnt = 0

while i <= (D-W):
    if document[i:i+W] == word:
        cnt += 1
        i += W
    else:
        i += 1

print(cnt)