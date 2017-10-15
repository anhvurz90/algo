'''
Created on Oct 15, 2017

@author: anhvu
'''
n = 8;
queen = "*";
rows = [False for r in range(n)];
cols = [False for c in range(n)];
d1 = [False for di1 in range(2 * n)];
d2 = [False for di2 in range(2 * n)];

board = [];
for r in range(n):
    board.append(input());

ret = "valid"
count = 0;
for r in range(n):
    for c in range(n):
        if board[r][c] == queen: 
            if (rows[r] | cols [c] |
                d1[r + c] | d2[n + r - c]):
                ret = "invalid";
                #print(r, c);
                #print(rows[r], cols[c], d1[r+c], d2[n+r-c])
            rows[r] = cols[c] = d1[r + c] = d2[n + r - c] = True;
            count+= 1;
if (count != 8):
    ret = "invalid"
print(ret);