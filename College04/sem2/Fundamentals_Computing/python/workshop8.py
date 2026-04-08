
sales_data = []
file = open("sales.txt","r+")
for line in file:
    parts = line.strip().split(",")
    row = [int(parts[0]), parts[1], int(parts[2]), int(parts[3])]
    sales_data.append(row)

for row in sales_data:
    product = row[1]
    units_sold = row[2]
    price_per_unit = row[3]
    total_revenue = units_sold * price_per_unit
    print(f"Product: {product}")
    print(f"Sold: {units_sold}")
    print(f"Price per unit: {price_per_unit}")
    print(f"Total_revenue: {total_revenue}")
    print("-" * 20)

max_revenue = 0
max_product = ""
for row in sales_data:
    product = row[1]
    units_sold = row[2]
    price_per_unit = row[3]
    total_revenue = units_sold * price_per_unit
    if total_revenue > max_revenue:
        max_revenue = total_revenue
        max_product = product

print(f"Product with highest revenue: {max_product}")
print(f"Highest revenue amount: {max_revenue}")


