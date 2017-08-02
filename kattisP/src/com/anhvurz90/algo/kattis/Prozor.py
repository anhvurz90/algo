'''
Created on Aug 2, 2017

@author: anhvu
'''

def check(c):
    if c == '*':
        return 1;
    return 0;

tri = [int(n) for n in input().split()];
r = tri[0];
s = tri[1];
kk = tri[2];
k = kk - 2;

pic = [];
for i in range(r):
    pic.append([c for c in input()]);

a = [[0 for x in range(s)] for y in range(r)];
b = [[0 for x in range(s)] for y in range(r)];

ret = 0;
for x in range(r-1):
    for y in range(s-1):
        if x == 0:
            if y == 0:
                a[x][y] = check(pic[x][y]);
            else:
                a[x][y] = check(pic[x][y]) + a[x][y-1];
        else:
            if y == 0:
                a[x][y] = check(pic[x][y]) + a[x-1][y];
            else:
                a[x][y] = check(pic[x][y]) + a[x][y-1] + a[x-1][y] - a[x-1][y-1];
        
#        if x == k-1:
#            if y == k-1:
#                b[x][y] = a[x][y];
#            elif y > k-1:
#                b[x][y] = a[x][y] - a[x][y - k];
#        elif x > k-1:
#            if y == k-1:
#                b[x][y] = a[x][y] - a[x - k][y];
#            elif y > k-1:
        if (x >= k) & (y >= k):
            b[x][y] = a[x][y] - a[x][y - k] - a[x - k][y] + a[x-k][y-k];

        if (b[x][y] > ret):
            ret = b[x][y];
            botx = x + 1;
            boty = y + 1;

topx = botx - k - 1;
topy = boty - k - 1;
pic[topx][topy] = pic[topx][boty] = pic[botx][topy] = pic[botx][boty] = '+';
for x in range(topx+1, botx):
    pic[x][topy] = pic[x][boty] = '|';
for y in range(topy+1, boty):
    pic[topx][y] = pic[botx][y] = '-';
print(ret);

for row in pic:
    print(''.join(row));
