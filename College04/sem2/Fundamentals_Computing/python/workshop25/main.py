from read import read_books_data
from operation import book_count_update
from write import update_data

def main():
    data = read_books_data()
    book_count_update(data) 
    update_data(data)        

if __name__ == "__main__":
    main()
