'''
Created on Sep 19, 2017

@author: anhvu
'''
signals = ['+', '-', '*', '//'];

count = int(input());
for test in range(count):
    ret = int(input());
    found = False;
    for a in signals:
        if found:
            break;
        for b in signals:
            if found:
                break;
            for c in signals:
                exp = "4 " + a + " 4 " + b + " 4 " + c + " 4 ";
                if (eval(exp) == ret):
                    found = True;
                    print(exp.replace("//", "/") + " = " + str(ret));
                    break;
    if not found:
        print("no solution");
