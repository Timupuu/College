import datetime

def create_unique_file(user_name):
    now = datetime.datetime.now()
    timestamp = now.strftime("%Y%m%d_%H%M%S")
    file_name = f"{user_name}_{timestamp}.txt"
    with open(file_name, "w") as f:
        f.write("This is a uniquely created file")
    print(file_name)

create_unique_file("Timupuu")


import random

def create_unique_file(user_name):
    rand_num = random.randint(1, 10000)
    file_name = f"{user_name}_{rand_num}.txt"
    with open(file_name, "w") as f:
        f.write("This is a uniquely created file")
    print(file_name)

create_unique_file("Timupuu")
```

#   Timupuu  (c3deed51-9736-45b7-930b-76b5c1429768) ───


