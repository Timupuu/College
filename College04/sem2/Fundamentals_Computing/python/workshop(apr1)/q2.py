#s = input("Give a word to check: ")
#sr=""
#for char in s:
#    sr = char + sr
#def palin(a,b):
#    if a == b:
#       print("This is a palindrome")
#   else:
#       print("This is not a palindrome")

#palin(s,sr)

x = input("Give your word: ")
y = input("Give your other word: ")

def ana(a, b):
    if len(a) == len(b):
        lista = []
        listb = []
        for char in a:
            lista.append(char)
        for char in b:
            listb.append(char)
        if set(lista) == set(listb):
            return True
        else:
            return False
    else:
        print("Invalid")
        return False

print(ana(x, y))





