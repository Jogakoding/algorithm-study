def solution(n, arr1, arr2):
    answer = []
    
    for x,y in zip(arr1,arr2):
        total = x | y
        row = ''
        for ch in str(bin(total))[2:]:
            if ch=='1':
                row += '#'
            else:
                row += ' '
        if len(row)!=n:
            row = ' '*(n-len(row)) + row
        answer.append(row)
    return answer
