m = int(input("Enter the number of rows: "))
n = int(input("Enter the number of columns: "))
matrix = []
for i in range(m):
    row =[]
    for j in range(n):
        if(i==j):
            row.append(0)
        elif (j > i):
            row.append(1)
        else:
            row.append(-1)
    matrix.append(row)

for row in matrix:
    print(row)
