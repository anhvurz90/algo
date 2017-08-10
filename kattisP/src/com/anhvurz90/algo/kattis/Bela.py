'''
Created on Aug 10, 2017

@author: anhvu
'''

board = [
['A', 11, 11],
['K', 4, 4],
['Q', 3, 3],
['J', 20, 2],
['T', 10, 10],
['9', 14, 0],
['8', 0, 0],
['7', 0, 0]]

pair = input().split();
n = int(pair[0]);
trump = pair[1];

sum = 0;
for i in range(n * 4):
    card = input();
    for x in board:
        if card[0] == x[0]:
            if card[1] == trump:
                sum+= x[1];
            else:
                sum+= x[2];
            break;
print(sum);