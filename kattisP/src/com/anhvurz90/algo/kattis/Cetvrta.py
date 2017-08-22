'''
Created on Aug 22, 2017

@author: anhvu
'''

pair0 = [int(i) for i in input().split()];
pair1 = [int(i) for i in input().split()];
pair2 = [int(i) for i in input().split()];

minx = min(pair0[0], pair1[0], pair2[0]);
maxx = max(pair0[0], pair1[0], pair2[0]);

miny = min(pair0[1], pair1[1], pair2[1]);
maxy = max(pair0[1], pair1[1], pair2[1]);

print(minx * 2 + maxx * 2 - pair0[0] - pair1[0] - pair2[0], miny * 2 + maxy * 2 - pair0[1] - pair1[1] - pair2[1]);
