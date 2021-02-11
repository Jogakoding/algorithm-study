T = int(input())

for test_case in range(1, T + 1 ):
    check = [0 for _ in range(10)]
    multi = int(input())
    temp = 0
    while sum(check) != 10:
        temp += multi
        for x in str(temp):
            check[int(x)] = 1
    print(f'#{test_case} {temp}')
    