T = int(input())
check = [2, 3, 5, 7, 11]

for testCase in range(1, T + 1):
    answer = []
    number = int(input())
    
    for data in check:
        temp = 0
        while True:
            q,r  = divmod(number,data)
            if r:
                break
            number = q
            temp += 1
        answer.append(str(temp))
    print(f"#{testCase} {' '.join(answer)}")