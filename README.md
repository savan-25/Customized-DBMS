# Marvellous DBMS

This project is a **mini command-line database management system (DBMS)** implemented in Java. It allows users to perform basic database operations like insert, delete, update, and aggregate functions using a `LinkedList` as the underlying data structure.

---

## Features

- Insert new employee records
- Display all employee records
- Display specific employee records by ID or Name
- Delete employee records by ID or Name
- Update employee address by ID
- Aggregate functions: Count, Sum, Average, Max, Min
- Delete entire database

---

## Technologies Used

- Java
- LinkedList for storing records
- HashMap for indexing by ID and Name
- Command-line interface for interaction

---

## Classes and Methods

### Employee Class
- **Fields:**
  - `Eno` (int): Employee ID
  - `Ename` (String): Employee Name
  - `Eage` (int): Employee Age
  - `Eaddress` (String): Employee Address
  - `Esalary` (int): Employee Salary
  - `Counter` (static int): Auto-incremented Employee ID

- **Constructor:**
  - `Employee(String name, int age, String address, int salary)`

- **Methods:**
  - `DisplayInformation()`: Prints employee details

### MarvellousDBMS Class
- **Fields:**
  - `LinkedList<Employee> lobj` : List of employee records
  - `HashMap<Integer, Employee> indexById` : Index by Employee ID
  - `HashMap<String, Employee> indexByName` : Index by Employee Name

- **Methods:**
  - `InsertIntoTable(String name, int age, String address, int salary)`
  - `SelectStarFrom()`
  - `SelectSpecific(int id)`
  - `SelectSpecific(String name)`
  - `DeleteData(int id)`
  - `DeleteData(String name)`
  - `UpdateRecord(int id, String newAddress)`
  - `AggregateCount()`
  - `AggregateSum()`
  - `AggregateAvg()`
  - `AggregateMax()`
  - `AggregateMin()`

### Program569 (Main Class)
- Command-line menu interface
- Handles user input safely using `readInt` and `readLine` methods
- Calls appropriate methods in `MarvellousDBMS` based on user selection

---

## How to Run

1. Clone the repository
2. Compile the program using:
   ```bash
   javac Program569.java
   ```
3. Run the program:
   ```bash
   java Program569
   ```
4. Follow the command-line menu to perform operations

---

## Sample Output

```
Welcome to Marvellous DBMS
-----------------------------------------------------
Please select your option based on your requirement
1 : Insert new record in the table
2 : Display all records from the table
...
```

---

## Notes
- Auto-incrementing IDs are handled using a static counter.
- Employee records are indexed by ID and Name for fast lookup.
- Aggregate functions operate on salary.
- The program supports multiple delete and update options.

---

## Author
- Your Name
- Contact: your.email@example.com
