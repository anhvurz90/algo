'''
Created on Jul 26, 2017

@author: anhvu
'''

count = [0] * 3;
s = "TCG";
for c in input():
    for i in range(len(s)):
        if (c == s[i]):
            count[i] += 1;
print(count[0]*count[0] + count[1]*count[1] + count[2]*count[2] + min(count) * 7);