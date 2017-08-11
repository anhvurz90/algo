'''
Created on Aug 11, 2017

@author: anhvu
'''
x = int(input());
p = input();

man = 'M';
woman = 'W';

m = 0;
w = 0;

l = len(p);
ret = l;
queue = '';
for i in range(l):
    current = p[0];
    if (current == man):
        if (m - w < x):
            queue+= p[0];
            m += 1;
            p= p[1:];
        elif (len(p) > 1) & (p[1] == woman):
            queue+= p[1];
            w += 1;
            p= p[0] + p[2:];
        else:
            ret = i;
            break;
    if (current == woman):
        if (w - m < x):
            queue+= p[0];
            w += 1;
            p= p[1:];
        elif (len(p) > 1) & (p[1] == man):
            queue+= p[1];
            m+= 1;
            p= p[0] + p[2:];
        else:
            ret = i;
            break;
#    print(current, m, w, queue);
print(ret);
    