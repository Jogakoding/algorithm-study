# 영문자를 제외한 다른 문자열을 없앤 조합을 찾는 함수
def find_combinations(word):
    str_lst = []
    for i in range(len(word)-1):
        if word[i:i+2].isalpha():
            str_lst.append(word[i:i+2])
    return sorted(str_lst)


# 합집합과 교집합 갯수를 세는 함수
def union_intersection_count(lst1, lst2):
    union = 0
    intersection = 0
    idx_1 = idx_2 = 0
    
    while idx_1 < len(lst1) and idx_2 < len(lst2):
        if lst1[idx_1] == lst2[idx_2]:
            intersection += 1
            idx_1 += 1
            idx_2 += 1
        elif lst1[idx_1] < lst2[idx_2]:
            idx_1 += 1
        else:
            idx_2 += 1
        union += 1
    union = union + len(lst1[idx_1:])  + len(lst2[idx_2:])
    return (union, intersection)


def solution(str1, str2):
    # 1. 대소문자 구분을 없애기 위해 다 소문자로 변환
    # 2. 숫자, 특수 문자를 제거한 글자쌍을 만드는 함수 호출
    str1_lst = find_combinations(str1.lower())
    str2_lst = find_combinations(str2.lower())
    
    union, intersection = union_intersection_count(str1_lst, str2_lst)
    answer = int((intersection / union) * 65536) if union != 0 else 65536
    
    return answer