'''
Created on Jul 28, 2017

@author: anhvu
'''

pair = [int(i) for i in input().split()];
m = pair[0];
n = pair[1];

four = [int(i) for i in input().split()];
u = four[0];
l = four[1];
r = four[2];
d = four[3];

ret = [ ['#' for x in range(n + l + r)] for y in range(m + u + d)];
for x in range(m + u + d):
    for y in range(n + l + r):
        if (((x + y) % 2) == 1):
            ret[x][y] = '.';


puzzle = [];
for i in range(m):
    puzzle.append(input());
    
for x in range(m):
    for y in range(n):
        ret[x + u][y + l] = puzzle[x][y];

for x in range(len(ret)):
    print(''.join(ret[x]));

