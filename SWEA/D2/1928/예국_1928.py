import base64

T = int(input())

for testCase in range(1, T + 1):
    string = input()
    answer = base64.b64decode(string)
    answer = answer.decode('utf-8')
    print(f'#{testCase} {answer}')

    # TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u