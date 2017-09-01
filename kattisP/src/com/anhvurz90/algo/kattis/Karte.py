'''
Created on Sep 1, 2017

@author: anhvu
'''
from _functools import reduce
s = input();
deck = {};
error = False;
for index in range(len(s) // 3):
    suite = s[index * 3];
    num = int(s[index*3 + 1 : index*3+3]);
    suiteSet = deck.get(suite);
    if suiteSet is None:
        suiteSet = set();
        suiteSet.add(num);
    else:
        if num in suiteSet:
            error = True;
            break;
        else:
            suiteSet.add(num);
    deck[suite] = suiteSet;

if error:
    print("GRESKA")
else:
    ret = [];
    for c in "PKHT":
        suiteSet = deck.get(c);
        if suiteSet is None:
            ret.append(13);
        else:
            ret.append(13 - len(suiteSet));
    print(reduce(lambda x, y: str(x) + " " + str(y), ret));