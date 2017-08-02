'''
Created on Aug 2, 2017

@author: anhvu
'''
from queue import Queue;
global count;
count = 0;
global n;
global cx;
global cy;

global board;
global primes;

global fr;
global to;

global movex;
movex = [0, 0, 1,-1];
global movey;
movey = [1,-1, 0, 0];

global ret;

global flag;
def nextC():
    global count;
    count += 1;
    return count;

def inputData():
    global fr;
    global to;
    pair = [int(i) for i in input().split()];
    fr = pair[0];
    to = pair[1];

def createBoard():
    global cx;
    global cy;
    global board;
    cx = n//2;
    cy = n//2;
    
    board = [[0 for x in range(n)] for y in range(n)];
    
    board[cx][cy] = nextC();
    
    for s in range(1, n//2):
        currx = cx + s;
        curry = cy + s;
    
        for i in range(2*s):
            currx -= 1;
            board[currx][curry] = nextC();
        for i in range(2*s):
            curry -=1;
            board[currx][curry] = nextC();
        for i in range(2*s):
            currx += 1;
            board[currx][curry] = nextC();
        for i in range(2*s):
            curry +=1;
            board[currx][curry] = nextC();

def findPrimes():
    global primes;
    primes = set();
    global n;
    for i in range(2, n*n):
        pr = True;
        for j in primes:
            if i % j == 0:
                pr = False;
                break;
        if (pr):
            primes.add(i);
            
def clearComposites():
    global board; 
    global primes;

    for i in range(n):
        for j in range(n):
#            print(i, j, board[i][j], board[i][j] in primes)
            if not (board[i][j] in primes):
                board[i][j] = 0;

def findWay():
    global n;
    global board;
    global primes;
    
    for x in range(n):
        for y in range(n):
            if board[x][y] == fr:
                find(x, y);
                break;
def find(x, y):
    global n;
    global board;
    global primes;
    global ret;
    
    q = Queue();
    q.put({'len':0, 'x':x, 'y': y, 'val': board[x][y]});
    flag[x][y] = False;
    while not q.empty():
        item = q.get();
#        print(item);
        for i in range(len(movex)):
            if canMove(item['x'] + movex[i], item['y'] + movey[i]):
                q.put({'len': item['len'] + 1, 'x': item['x'] + movex[i], 'y': item['y'] + movey[i], 'val': board[item['x'] + movex[i]][item['y'] + movey[i]]});
                if (board[item['x'] + movex[i]][item['y'] + movey[i]] == to):
                    ret = item['len'] + 1;
                    return;
                flag[item['x'] + movex[i]][item['y'] + movey[i]] = False;

def canMove(x, y):
    global board;
    global primes;
    if (x < 0) | (y < 0) | (x >=n) | (y >=n):
        return False;
    if (not flag[x][y]) | (board[x][y] in primes) | (board[x][y] == 0):
        return False;
    return True;

n = 107;
flag = [[True for x in range(n)] for y in range(n)];
createBoard();
findPrimes();
count = 0;
while True:
    try:
        inputData();
        flag = [[True for x in range(n)] for y in range(n)];
        ret = "impossible";
        findWay();
        count += 1;
        print("Case " + str(count) + ":", ret);
    except EOFError:
        break;


#clearComposites();
#for x in board:
#    print(x);


#print(primes);