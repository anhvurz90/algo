'''
Created on Jul 31, 2017

@author: anhvu
'''

def toWords(st):
    try:
        i = int(st);
    except ValueError:
        return st;
    return say(i);

def say(num):
    if num == 0:
        return 'zero';
    elif num == 10:
        return 'ten';
    elif num == 11:
        return 'eleven';
    elif num == 12:
        return 'twelve';
    elif num == 13:
        return 'thirteen';
    elif num == 14:
        return 'fourteen';
    elif num == 15:
        return 'fifteen';
    elif num == 16:
        return 'sixteen';
    elif num == 17:
        return 'seventeen';
    elif num == 18:
        return 'eighteen';
    elif num == 19:
        return 'nineteen';
    
    a = num // 10;
    wa = "";
    if a == 9:
        wa = "ninety";
    elif a == 8:
        wa = "eighty";
    elif a == 7:
        wa = "seventy";
    elif a == 6:
        wa = "sixty";
    elif a == 5:
        wa = "fifty";
    elif a == 4:
        wa = "forty";
    elif a == 3:
        wa = "thirty";
    elif a == 2:
        wa = "twenty";
        
    wb = "";
    b = num % 10;
    if b == 9:
        wb = "nine";
    if b == 8:
        wb = "eight";
    if b == 7:
        wb = "seven";
    if b == 6:
        wb = "six";
    if b == 5:
        wb = "five";
    if b == 4:
        wb = "four";
    if b == 3:
        wb = "three";
    if b == 2:
        wb = "two";
    if b == 1:
        wb = "one";
        
    if wa == "":
        return wb;
    if wb == "":
        return wa;
    return wa + '-' + wb;
    return ret;

while (True):
    try:
        inp = input();
    except EOFError:
        break;
    
    vals = inp.split();
    ret = ''.join(" " + toWords(c) for c in vals);
    
    print(ret[1].upper() + ret[2:]);