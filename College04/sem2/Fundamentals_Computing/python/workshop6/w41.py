data = { }
n = int(input("Enter the number of students: "))
for i in range(n):
    key = input("Enter the name of the student: ")
    mark = int(input("Enter the obtained marks: "))
    data[key] = mark
maxm = 0
for mark in data.values():
    if(mark > maxm):
       maxm = mark

minm = 100
for mark in data.values():
    if(mark < minm):
       minm = mark
tot = 0
for mark in data.values():
    tot += mark
avg = tot/n


print(data)
print(maxm)
print(minm)
print(avg)
