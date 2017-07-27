'''
Created on Jul 27, 2017

@author: anhvu
'''

t = int(input());
for i in range (t):
    n = int(input());
    votes = [];
    for j in range(n):
        votes.append(int(input()));
        
    m = max(votes);
    s = sum(votes);
    count = 0;
    
    for j in range(n):
        if (votes[j] == m):
            count += 1;
            ind = j;
    
#    print(votes);
#    print(m, s, count, ind);
    
    
    if (count == 1):
        if (m > s / 2):
            print("majority winner", ind + 1);
        else:
            print("minority winner", ind + 1);
    else:
        print("no winner");
    