x = input("Give me a word: ")
def count_vowels(word):
    word = word.lower()
    vowels = "aeiou"
    count = 0
    for char in word:
        if char in vowels:
            count += 1
    return count
print("The number of vowels are:",count_vowels(x))
con = len(x)-count_vowels(x)
print("The number of consonats are:",con)


x = input("Give me a word: ")
def count_n(word):
    word = word.lower()
    n = "0123456789"
    countn = 0
    for char in word:
        if char in n:
            countn += 1
    return countn
def count_v(word):
    word = word.lower()
    n = "aeiou"
    countv = 0
    for char in word:
        if char in n:
            countv += 1
    return countv

print("The number of numeric values are:",count_n(x))
con = len(x)-count_n(x)-count_v(x)
print("The number of consonats are:",con)

