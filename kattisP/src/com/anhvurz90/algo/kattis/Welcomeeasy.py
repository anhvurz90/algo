'''
Created on Jul 21, 2017

@author: anhvu
'''
def full_length(st):
    ret = st;
    while len(ret) < 4:
        ret = "0" + ret;
    return ret;

n = int(input());
welcome = "welcome to code jam";

for i in range(n):
    st = input();
    count = [[0 for x in range(len(st))] for y in range(len(welcome))]
#    print(len(count), len(count[0])); 
    #print(i, st, count);
    for index in range(len(st)):
        if st[index] == 'w':
            count[0][index] = 1;
    
    for idx_w in range(1, len(welcome)):
        for idx_st in range(len(st)):
            if (st[idx_st] == welcome[idx_w]):
                for idx2_st in range(idx_st):
                    if (st[idx2_st] == welcome[idx_w-1]):
#                        print(idx_w);
                        count[idx_w][idx_st] += count[idx_w-1][idx2_st];
                        count[idx_w][idx_st] %= 10000;
#                        print(count[idx_w]);
#     for r in range(len(count)):
#         print(r, count[r]);
    print("Case #" + str(i+1) + ": " + full_length(str(sum(count[len(welcome) - 1]))));