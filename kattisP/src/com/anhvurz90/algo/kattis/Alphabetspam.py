'''
Created on Sep 16, 2017

@author: anhvu
'''

ws = 0;
lo = 0;
up = 0;
sy = 0;
s = input();
l = len(s);
for c in s:
    if c == '_':
        ws += 1;
    elif ('a' <= c) & (c <= 'z'):
        lo += 1;
    elif ('A' <= c) & (c <= 'Z'):
        up += 1;
print(ws / l);
print(lo / l);
print(up / l);
print((l - ws - lo - up) / l);

