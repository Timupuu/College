def read_books_data(file_path="./books.txt"):
    books_data = []
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            for line in f:
                parts = line.strip().split(',')
                if len(parts) == 5:
                    # Convert id and year and quantity to int
                    try:
                        book_id = int(parts[0])
                        title = parts[1].strip()
                        author = parts[2].strip()
                        year = int(parts[3])
                        quantity = int(parts[4])
                        books_data.append([book_id, title, author, year, quantity])
                    except ValueError:
                        continue  # Skip lines with invalid data
    except FileNotFoundError:
        print(f"Error: File '{file_path}' not found.")
    return books_data

def display_books_data(books_data):
    if not books_data:
        print("No data to display.")
        return
    headers = ["ID", "Title", "Author", "Year", "Quantity"]
    print("{:<5} {:<30} {:<20} {:<6} {:<8}".format(*headers))
    print("-" * 75)
    for book in books_data:
        print("{:<5} {:<30} {:<20} {:<6} {:<8}".format(*book))

def write_books_data(books_data,file_path="./sales.txt"):
    try:
        with open(file_path, 'w', encoding='utf-8') as f:
            for book in books_data:
                line = "{},{},{},{},{}\n".format(book[0], book[1], book[2], book[3], book[4])
                f.write(line)
    except Exception as e:
        print(f"Error writing to file: {e}")


