nums = [2,15,7,11]
numSet = set(nums)
target = 9

pair = 0
i = 0
for idx in range(0, len(nums)):
    i = idx
    pair = target - nums[idx]
    if pair in numSet:
        break

print(str(i) + ", " + str(nums.index(pair)))