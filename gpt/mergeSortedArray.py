nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]
temp = []

nums1 = [i for i in nums1 if i != 0]

for idx in range(5, -1, -1):
    n1 = nums1.pop(-1) if nums1 else -1
    n2 = nums2.pop(-1) if nums2 else -1

    if n1 >= n2:
        temp.append(n1)
        nums2.append(n2)
    else:
        temp.append(n2)
        nums1.append(n1)

temp.reverse()
print(temp)