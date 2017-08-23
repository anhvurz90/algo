'''
Created on Aug 23, 2017

@author: anhvu
'''
n = int(input());

for test in range(n):
    s = input();
    t = input();
    ret = ['.' for i in range(len(s))];
    for count in range(len(s)):
        if (s[count] != t[count]):
            ret[count] = '*';
    print(s);
    print(t);
    print("".join(c for c in ret));