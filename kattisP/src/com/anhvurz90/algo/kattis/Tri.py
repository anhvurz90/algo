'''
Created on Jul 20, 2017

@author: anhvu
'''
st = input().split(" ");
vals = [int(i) for i in st];
a = vals[0];
b = vals[1];
c = vals[2];

if a+b==c:
    print(st[0]+"+"+st[1]+"="+st[2]);
elif a-b==c:
    print(st[0]+"-"+st[1]+"="+st[2]);
elif a*b==c:
    print(st[0]+"*"+st[1]+"="+st[2]);
elif abs(a/b-c) < 0.0001:
    print(st[0]+"/"+st[1]+"="+st[2]);
elif a==b+c:
    print(st[0]+"="+st[1]+"+"+st[2]);
elif a==b-c:
    print(st[0]+"="+st[1]+"-"+st[2]);
elif a==b*c:
    print(st[0]+"="+st[1]+"*"+st[2]);
elif abs(a-b/c) < 0.0001:
    print(st[0]+"="+st[1]+"/"+st[2]);
