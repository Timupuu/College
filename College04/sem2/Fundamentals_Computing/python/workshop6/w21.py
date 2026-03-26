rows = int(input("Enter the number of rows: "))
cols = int(input("Enter the number of columns: "))
matrix = []
for i in range(rows):
    row =[]
    for j in range(cols):
        if(i==j):
            row.append(1)
        elif (j > i):
            row.append(2)
        else:
            row.append(3)
    matrix.append(row)

for row in matrix:
    print(row)
