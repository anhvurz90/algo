'''
Created on Jul 20, 2017

@author: anhvu
'''

texts = input().split(" ");
h = int(texts[0]);
m = int(texts[1]);
m -= 45;
if m < 0:
    m+= 60;
    h-= 1;
if (h < 0):
    h+= 24;
print(h, m);