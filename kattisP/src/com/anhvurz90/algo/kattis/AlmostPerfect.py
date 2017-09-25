'''
Created on Sep 25, 2017

@author: anhvu
'''
while (True):
    try:
        n = int(input());
        sum = 0;
        divisor = 1;
        while (divisor * divisor <= n):
            if (n % divisor == 0):
                sum+= divisor;
                if (divisor != 1):
                    complement = n // divisor;
                    if (complement != divisor):
                        sum+= complement;
            divisor+= 1;
        
        ret = "not perfect";
        if (abs(sum - n) <= 2):
            ret = "almost perfect";
        if (sum == n):
            ret = "perfect"
        
        print(n, ret);
    except EOFError:
        break;
