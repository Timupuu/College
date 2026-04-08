numbers_str = input("Enter a string of numbers: ")
numbers = []

for char in numbers_str:
    numbers.append(int(char))

total = 0
for num in numbers:
    total += num

print("Sum:", total)

