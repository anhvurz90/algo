'''
Created on Oct 19, 2017

@author: anhvu
'''
rev = [0,1,2,5,6,8,9];
rev = [0,1,2,5,9,8,6];
revLen = len(rev);

rev2 = [0,1,2,-1,-1,5,9,-1,8,6];

def reverse(k):
    b = 1;
    while (b <= k):
        b*= 7;
        
    ret = "";
    
    while (b > 1):
        b//= 7;
        ret += str(rev[k//b]);
        if (b > 0):
            k%= b;
    return ret;

def reverseSt(num):
    r =  str(num)[::-1];
    ret= "";
    for c in r:
        if (rev2[int(c)] == -1):
            return "";
        ret+= str(rev2[int(c)]);
    return ret;

def ok(num):
    return len(num) > 0;

def reverse2(k):
    count = 0;
    current = 0;
    while (count < k):
        current += 1;
        r = reverseSt(current);
        if (ok(r)):
            count+= 1;
        if (count == k):
            return r;
    return "";
    
while (True):
    try:
        k = int(input());
        ret = reverse(k);
#        ret2 = reverse2(k);
        print(ret[::-1]);
    except EOFError:
        break;