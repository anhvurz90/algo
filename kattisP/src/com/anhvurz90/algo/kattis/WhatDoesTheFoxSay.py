'''
Created on Jul 21, 2017

@author: anhvu
'''
test_num = int(input());
for i in range (test_num):
    all_sounds = input().split();
    pregathered = "";
    di = dict();
    sounds = [];
    while pregathered != "what does the fox say?":
        pregathered = input();
        if (pregathered != "what does the fox say?"):
            sound = pregathered.split()[2];
            sounds.append(sound);
            di[sound] = 1;
    ret = [s for s in all_sounds if di.get(s) == None];
    
    print("".join(i + " " for i in ret));
