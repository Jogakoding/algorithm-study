"""
s = 문자열
n = 몇글자 단위로 쪼갤지
l = 문자열의 길이
prev = 이전 n개의 문자
now = 현재 n개의 문자
rep = 현재 문자가 몇번 반복됐는지
cnt = 압축 후 문자열 길이
"""

def compress(s, n, l):
    prev = s[:n]
    cnt = n
    rep = 1
    for i in range(1, l//n):
        now = s[n*i:n*(i+1)]
        if prev != now:
            cnt += n
            rep = 1
        else:
            # 이번에 처음 반복되는 문자라면 앞에 숫자가 추가되기 때문에 한글자 추가
            if rep in [1, 9, 99, 999]:
                cnt += 1
            rep += 1
        prev = now
    return cnt
        
    

def solution(s):
    l = minimum = len(s)
    for n in range(1, l//2+1):
        cnt = compress(s, n, l)
        if l % n:
            cnt += (l % n)
        if cnt < minimum:
            minimum = cnt
    return minimum