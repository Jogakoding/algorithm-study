N = int(input())

files = [input() for _ in range(N)]
search = ''

for i in range(len(files[0])):
    pivot_letter = files[0][i]
    for file in files:
        if file[i] != pivot_letter:
            search += '?'
            break
    else:
        search += pivot_letter

print(search)