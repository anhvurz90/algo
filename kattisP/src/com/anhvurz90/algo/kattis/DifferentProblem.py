'''
Created on Jul 31, 2017

@author: anhvu
'''

while (True):
    try:
        inp = input();
    except EOFError:
        break;
    if (len(inp) == 0):
        break;
    
    pair = [int(i) for i in inp.split()];
    print(abs(pair[0] - pair[1]));
