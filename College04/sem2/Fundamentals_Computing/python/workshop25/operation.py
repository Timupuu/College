def book_count_update(books_data):
    try:
        book_id = int(input("Enter book id (numeric): "))
        book_count = int(input("Enter new book count (numeric): "))
    except ValueError:
        print("Invalid input. Please enter numeric values.")
        return

    found = False
    for book in books_data:
        if int(book[0]) == book_id:
            book[4] = str(book_count)  # Assuming book[2] is the count
            found = True
            print(f"Book ID {book_id} updated with count {book_count}.")
            break

    if not found:
        print("Book ID not found.")

