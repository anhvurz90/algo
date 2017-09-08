'''
Created on Sep 8, 2017

@author: anhvu
'''

def area(a, b, c, d):
    return min(a, b) * min(c, d);
l = [int(i) for i in input().split()];

area1 = area(l[0], l[1], l[2], l[3]);
area2 = area(l[0], l[2], l[1], l[3]);
area3 = area(l[0], l[3], l[1], l[2]);

print(max([area1, area2, area3]));