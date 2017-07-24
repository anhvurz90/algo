'''
Created on Jul 24, 2017

@author: anhvu
'''
import sys

global fm;
 
def find_min(lo, hi, box_num):
    global fm;
#    print(lo, hi, box_num);
    if (fm[lo][hi][box_num] == -1):
        if (box_num == 1):
            fm[lo][hi][box_num] = (lo + hi)*(hi-lo+1) // 2;
        elif (lo == hi):
            fm[lo][hi][box_num] = lo;
        elif (lo > hi):
            fm[lo][hi][box_num] = 0;
        else:
            minV = sys.maxsize;
            for i in range (0, hi - lo):
#                for k in range(1, box_num - 1):
                minV = min(minV, (lo + i) + max(find_min(lo, lo + i - 1, box_num - 1), find_min(lo + i + 1, hi, box_num)));
            fm[lo][hi][box_num] = minV;
             
    return fm[lo][hi][box_num]; 
 
n = int(input());
for test in range (n):
    pair = [int(i) for i in input().split()];
    fm = [[[-1 for x in range (pair[0]+1)] for y in range(pair[1]+1)] for z in range(pair[1]+1)];
    print(find_min(1, pair[1], pair[0]));


# n = int(input());
# for test in range (n):
#     pair = [int(i) for i in input().split()];
#     fm = [[[5050 for x in range (pair[0]+1)] for y in range(pair[1]+1)] for z in range(pair[1]+1)];
#     
#     for box in range(pair[0] + 1):
#         for dif in range(0, pair[1] + 1):
#             for lo in range(pair[1] + 1 - dif):
#                 hi  = lo + dif;
#                 if (box == 1):
#                     fm[lo][hi][box] = (lo + hi)*(hi-lo+1) // 2;
#                 elif (lo == hi):
#                     fm[lo][hi][box] = lo;
#                 elif (lo > hi):
#                     fm[lo][hi][box] = 0;
#                 elif (box == 0):
#                     fm[lo][hi][box] = 0;
#                 elif (box > 1):
#                     for i in range(0, hi - lo):
#                         fm[lo][hi][box] = min(fm[lo][hi][box], (lo + i) + max(fm[lo][lo + i - 1][box - 1], fm[lo + i + 1][hi][box]));
#                 #print(lo, hi, box, fm[lo][hi][box]);
#     print(fm[1][pair[1]][pair[0]]);