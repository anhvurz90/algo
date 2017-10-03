'''
Created on Oct 3, 2017

@author: anhvu
'''
count = 0;
pow2Len = 20;
pow2 = [1];
oneHalf = [1.5];
for i in range(1, pow2Len):
    pow2.append(2 * pow2[i-1]);
    oneHalf.append(oneHalf[i-1] * oneHalf[i-1]);
#print(pow2);
#print(oneHalf);
while (True):
    try:
        count+= 1;
        n = int(input());

        val = 3;
        for i in range(pow2Len):
            if (n & pow2[i] == pow2[i]):
                val*= oneHalf[i];
        
        size = 0;
        strVal = str(val);
        ind = strVal.find("+");
        #print(strVal);
        if (ind == -1):
            dotInd = strVal.find(".");
            if (dotInd == -1):
                size = len(strVal);
            else:
                inte = strVal[:dotInd];
                size = len(inte);
        else:
            po = strVal[ind:];
            size = 1 + int(po);
        
        print("Case", str(count) + ":", size);
    except EOFError:
        break;
