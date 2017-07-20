'''
Created on Jul 20, 2017

@author: anhvu
'''
count = 0;
for c in input():
    if (c == 'W'): 
        count +=1;
    else:
        count -=1;

if count == 0:
    print(1);
else:
    print(0);
