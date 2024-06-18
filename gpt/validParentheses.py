input = list(input())
stack = []
brackets = {
    '(':')',
    '{':'}',
    '[':']'
}

answer = True

for v in input:
    if v in brackets.keys():
        stack.append(v)
    else:
        o = stack.pop()
        if brackets[o] != v:
            answer = False
            break

print(answer)
        