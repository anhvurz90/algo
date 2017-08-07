'''
Created on Aug 6, 2017

@author: anhvu
'''
global f;
global x;
x = '-';
global o;
o = 'o';
n = int(input());
m = pow(2, 12);

f = [-1 for i in range(m)];
f[0] = 0;

def toInt(game):
    global o;
    ret = 0;
    for c in game:
        ret *= 2;
        if (c == o):
            ret += 1;
    return ret;

def canMove(game):
    global x;
    global o;
    for i in range(len(game) - 2):
        if (game[i] == x) & (game[i+1] == o) & (game[i+2] == o):
            return True;
        if (game[i] == o) & (game[i+1] == o) & (game[i+2] == x):
            return True;
    return False;
    
def countPebble(game):
    global o;
    ret = 0;
    for i in range(len(game)):
        if (game[i] == o):
            ret += 1;
    return ret;
def findF(game):
    global x;
    global o;
    num = toInt(game);
    if f[num] == -1:
        if not canMove(game):
            f[num] = countPebble(game);
        else:
            ret = len(game);
            for i in range(len(game) - 2):
            #checkMoveLeft
                #print(game, i);
                if (game[i] == x) & (game[i+1] == o) & (game[i+2] == o):
                    game1 = game[:i] + o + x + x + game[i+3:];
                    ret = min(ret, findF(game1));
            #checkMoveRight
                if (game[i] == o) & (game[i+1] == o) & (game[i+2] == x):
                    game2 = game[:i] + x + x + o + game[i+3:];
                    ret = min(ret, findF(game2));
            f[num] = ret;
    return f[num];
    
for i in range(n):
    game = input();
    print(findF(game));


