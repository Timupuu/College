#For sum of all odd numbers
def sum_(n):
    if n%2!=0:
        sumo = ((n+1)/2)**2
    else:
        n = n-1
        sumo = ((n+1)/2)**2

    return sumo

a = int(input("Give a number: "))
print("The sum of odd numbers upto n is ",sum_(a))

#For sum of all even numbers
# def sum_(n):
#    if n%2==0:
#        sumo = (n/2)(n/2+1)
#    else:
#        n = n-1
#        sumo = (n/2)(n/2+1)
#
#   return sumo

#a = int(input("Give a number: "))
#print("The sum of even numbers upto n is ",sum_(a))

