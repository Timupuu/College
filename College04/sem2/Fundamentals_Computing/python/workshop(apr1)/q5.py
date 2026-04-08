
word1 = input("Enter first word: ")
word2 = input("Enter second word: ")

common_letters = list(set(word1) & set(word2))

print(common_letters)

word1 = input("Enter first word: ")
word2 = input("Enter second word: ")

unique_word1 = list(set(word1) - set(word2))
unique_word2 = list(set(word2) - set(word1))

print("Unique in word1:", unique_word1)
print("Unique in word2:", unique_word2)
