matA = [[1,2,3,],[8,9,4],[7,6,5]]
matB = [[2,7,6],[9,5,1],[4,3,8]]
sumDi = 0
sumu = 0
sumd = 0
for i in range(len(matA)):
            sumDi +=matA[i][i] 
for i in range(len(matB)):
    sumDi +=matB[i][i]
print(sumDi)

for i in range(len(matA)):
    for j in range(len(matA[i])):
        if (i<j):
            sumu +=matA[i][j]
        elif (i>j):
            sumd += matA[i][j]

for i in range(len(matB)):
    for j in range(len(matB[i])):
        if (i<j):
            sumu +=matB[i][j]
        elif (i>j):
            sumd += matB[i][j]

print(sumu)
print(sumd)

