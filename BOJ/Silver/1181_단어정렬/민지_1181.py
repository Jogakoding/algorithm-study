N = int(input())

words = sorted(list(set(list(input() for _ in range(N)))), key=lambda x: (len(x), x))

for word in words:
    print(word)
