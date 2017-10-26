'''
Created on Oct 26, 2017

@author: anhvu
'''
global count;
global flag;

def find(pos):
    global count;
    global flag;
    if (pos == n):
        count+= 1;
    else:
        ok = True;
        for i in range(pos):
            if (flag[i] & (pos in noMix[i])):
                ok = False;
                break;
            
        if ok:
            flag[pos] = True;
            find(pos + 1);
            
        flag[pos] = False;
        find(pos+1);

[n, m] = [int(i) for i in input().split()];
noMix = [set() for i in range(n)];
for noMixPairId in range(m):
    [a, b] = [int(i) for i in input().split()];
    #print(a, b);
    noMix[a-1].add(b-1);
    noMix[b-1].add(a-1);
#print(noMix);

flag = [False for i in range(n)];
count = 0;
find(0);

print(count);