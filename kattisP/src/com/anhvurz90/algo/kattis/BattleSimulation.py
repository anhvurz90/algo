'''
Created on Sep 27, 2017

@author: anhvu
'''
from _collections import deque

moves = input();

dq = deque();
for m in moves:
    counter = "";
    if (m == 'R'):
        counter = 'S';
    elif (m == 'B'):
        counter = 'K';
    elif (m == 'L'):
        counter = 'H';
    dq.append(counter);
    if (len(dq) >= 3):
        a3 = dq.pop();
        a2 = dq.pop();
        a1 = dq.pop();
        if (a1 != "C") & (a2 != "C") & (a3 != "C") & (a1 != a2) & (a2 != a3) & (a3 != a1):
            dq.append("C");
        else:
            dq.append(a1);
            dq.append(a2);
            dq.append(a3);
print(''.join(dq));