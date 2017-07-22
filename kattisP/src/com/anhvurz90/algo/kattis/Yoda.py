'''
Created on Jul 22, 2017
 
@author: anhvu
'''
 
def fill(st, leng):
    while len(st) < leng:
        st += "0";
    return st;
 
def collide(s1, s2):
    ret = "";
    for i in range(len(s1)):
        if (s1[i] >= s2[i]):
            ret += str(s1[i]);
    if (ret == ""):
        return "YODA";
    return int(ret[::-1]);
 
def yoda(s1, s2):
    ret = True;
    for i in range(len(s1)):
        if (s1[i] >= s2[i]):
            return False;
    return ret;
first = input();
second = input();
maxLen = max(len(first), len(second));
 
f = first;
s = second;
 
first = fill(first[::-1], maxLen);
second = fill(second[::-1], maxLen);
 
fRet = collide(first, second);
sRet = collide(second, first);
 
if (len(f) == len(s)):
    if yoda(f, s):
        fRet = "YODA";
    if yoda(s, f):
        sRet = "YODA";
 
print(fRet);
print(sRet);