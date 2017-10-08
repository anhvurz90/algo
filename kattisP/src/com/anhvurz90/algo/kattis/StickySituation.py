'''
Created on Oct 8, 2017

@author: anhvu
'''
def isTriangle(a, b, c):
    if (a + b > c) & (a + c > b) & (b + c > a):
        return True;
    return False;
n = int(input());
sticks = [int(i) for i in input().split()];
sticks = sorted(sticks);

ok = False;
for i in range(n - 2):
    if isTriangle(sticks[i], sticks[i+1], sticks[i+2]):
        ok = True;
        break;

if (ok):
    print("possible");
else:
    print("impossible");