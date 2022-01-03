N = int(input())
actions = []
stack = []

for _ in range(N):
    actions += list(input().split())

i = 0
while i < len(actions):
    if actions[i] == 'push':
        i += 1
        stack.append(actions[i])
    elif actions[i] == 'pop':
        print(stack.pop() if stack else -1)
    elif actions[i] == 'size':
        print(len(stack))
    elif actions[i] == 'empty':
        print(0 if stack else 1)
    else:
        print(stack[len(stack)-1] if stack else -1)
    i += 1
    