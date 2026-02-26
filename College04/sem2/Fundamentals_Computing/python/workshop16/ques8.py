a = int(input('Enter the a term'))
b = int(input('Enter the b term'))
c = int(input('Enter the c term'))

x1=(-b+(b**2-4*a*c)**(1/2))/(2*a)
x2=(-b-(b**2-4*a*c)**(1/2))/(2*a)

print('The roots are',x1,x2)
