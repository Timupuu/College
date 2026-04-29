import os

INVENTORY_FILE = "medicines.txt"

def read_inventory(filepath=INVENTORY_FILE):
    medicines = []
    if not os.path.exists(filepath):
        print(f"[ERROR] Inventory file '{filepath}' not found.")
        return medicines

    with open(filepath, "r") as f:
        for line_num, line in enumerate(f, start=1):
            line = line.strip()
            if not line:
                continue
            parts = [p.strip() for p in line.split(",")]
            if len(parts) != 6:
                print(f"[WARNING] Line {line_num} skipped (bad format): {line}")
                continue
            try:
                medicine = {
                    "name":           parts[0],
                    "brand":          parts[1],
                    "stock_tablets":  int(parts[2]),
                    "rate_tablet":    float(parts[3]),
                    "rate_strip":     float(parts[4]),
                    "tablets_strip":  int(parts[5]),
                }
                medicines.append(medicine)
            except ValueError:
                print(f"[WARNING] Line {line_num} skipped (numeric error): {line}")

    return medicines

def display_inventory(medicines):
    if not medicines:
        print("\n  [!] No medicines found in inventory.\n")
        return

    print("\n" + "=" * 85)
    print(f"  {'MedStore Pvt. Ltd.':^81}")
    print(f"  {'Current Medicine Inventory':^81}")
    print("=" * 85)
    header = (f"  {'#':<4} {'Medicine':<22} {'Brand':<20} {'Stock':>8}"
              f" {'Rs/Tab':>8} {'Rs/Strip':>10} {'Tab/Strip':>10}")
    print(header)
    print("-" * 85)
    for idx, m in enumerate(medicines, start=1):
        strips_available = m['stock_tablets'] // m['tablets_strip']
        print(f"  {idx:<4} {m['name']:<22} {m['brand']:<20} "
              f"{m['stock_tablets']:>8} {m['rate_tablet']:>8.2f} "
              f"{m['rate_strip']:>10.2f} {m['tablets_strip']:>10}  "
              f"({strips_available} strips)")
    print("=" * 85 + "\n")

if __name__ == "__main__":
    medicines = read_inventory()
    display_inventory(medicines)
