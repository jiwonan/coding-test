input = list(map(int, input().split(',')))
dp = []

dp.append(input[0])

for idx in range(1, len(input)):
    dp.append(max(dp[idx-1]+input[idx], input[idx]))

print(max(dp))