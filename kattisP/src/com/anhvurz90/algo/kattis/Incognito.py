'''
Created on Oct 2, 2017

@author: anhvu
'''

testNum = int(input());
for testIndex in range(testNum):
    attrs = int(input());
    m = dict();
    for i in range(attrs):
        pair = input().split();
        count = m.get(pair[1], 0) + 1;
        m[pair[1]] = count;

    ret = 1;
    for k in m.items():
        ret*= (k[1] + 1);
    print(ret - 1);
