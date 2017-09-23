'''
Created on Sep 23, 2017

@author: anhvu
'''
from _functools import reduce

def toString(ls):
    return reduce(lambda x, y: x + " + " + y, ls);
varVals = {};
while (True):
    expression = input();
    if (expression == "0"):
        break;
    if (expression.find("=") > -1):
        pair = expression.split(" = ");
        varVals[pair[0]] = int(pair[1]);
    else:
#         for var, val in varVals.items():
#             expression = expression.replace(var, val);
        operators = expression.split(" + ");
        
        scalar = 0;
        newOps = [];
        for o in operators:
            if varVals.get(o) != None:
                scalar+= varVals.get(o);
            else:
                try:
                    scalar += int(o); 
                except ValueError:
                    newOps.append(o); 
        if (scalar == 0):
            if (len(newOps) == 0):
                print(0);
            else:
                print(toString(newOps));
        else:
            if (len(newOps) == 0):
                print(scalar);
            else:
                print(scalar, "+", toString(newOps));
        