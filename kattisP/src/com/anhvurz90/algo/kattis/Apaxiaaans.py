'''
Created on Aug 8, 2017

@author: anhvu
'''
s = input();
ret = s[0];

for i in range(1, len(s)):
    if s[i] != s[i-1]:
        ret += s[i];

print(ret);