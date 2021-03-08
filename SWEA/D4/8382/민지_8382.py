import sys
sys.stdin = open('8382_input.txt')

T = int(input())

def get_moves(a, b):
    pass

for tc in range(1, T+1):
    x1, y1, x2, y2 = map(int, input().split())
    dx, dy = abs(x1-x2), abs(y1-y2)

    if (dx-dy) % 2:
        result = (max(dx,dy)-1) * 2 + 1
    else:
        result = 2 * max(dx,dy)
    print("#%d %d" % (tc, result))