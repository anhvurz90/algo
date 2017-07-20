'''
Created on Jul 20, 2017

@author: anhvu
'''
st = input();
global ret
ret = "";
ok = False;

def check(s):
    global ret;
    if (s > st):
        if (ret == "") | (s < ret):
            ret = s;
    return;

def checkAllPermutation(s, st):
    if (st == ""):
        check(s);
    elif (len(st) == 1):
        check(s + st);
    else:
        for i in range(len(st)):
            checkAllPermutation(s + st[i], st[:i] + st[i+1:]);
    return;

for i in range(len(st)-1):
    if (st[i] < st[i+1]):
        ok = True;
        
if (not ok):
    print(0);
else:    
    checkAllPermutation("", st);
    print(ret);

