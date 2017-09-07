'''
Created on Sep 7, 2017

@author: anhvu
'''

while (True):
    try:
        size = int(input());
        if (size == 1):
            print(1);
        else:
            print(size * 2 - 2);
    except EOFError:
        break;
