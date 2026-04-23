def update_data(books_data, output_file_path="./books.txt"):
    with open(output_file_path, 'w', encoding='utf-8') as file:
        for book in books_data:
            file.write("{},{},{},{},{}\n".format(book[0], book[1], book[2], book[3], book[4]))
