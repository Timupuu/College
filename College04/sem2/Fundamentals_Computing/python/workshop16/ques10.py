it1name = input('Enter the name of the 1st product: ')
int1price = int(input('Enter the price of the 1st product: '))
it2name = input('Enter the name of the 2nd product: ')
int2price = int(input('Enter the price of the 2nd product: '))
it3name = input('Enter the name of the 3rd product: ')
int3price = int(input('Enter the price of the 3rd product: '))

total = int1price + int2price + int3price
tax = (13/100) * total
gtotal = total + tax

print('Name     Price')
print(int1name,'    ',int1price)
print(int2name,'    ',int2price)
print(int3name,'    ',int3price)
