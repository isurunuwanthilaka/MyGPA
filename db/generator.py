import time

foa = open("data.txt").read().splitlines()
fob = open("struct.txt","a+")

for i in foa:
    l = tuple(i[1:-1].split(","))    
    fob.write("'%s':{'departmentId':'1','semesterNo':'%s','name':'%s','credit':'%s','active':true,'gpa':%s},\n"%l)

fob.close()
