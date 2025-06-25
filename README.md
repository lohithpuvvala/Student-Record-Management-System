
## 📘 Student Management System (Console-based Java Project)

A simple Java console application for managing student records using core Java concepts like classes, collections, and input/output handling.

---

### 📂 Features

* ✅ Add new students
* ✅ View all students
* ✅ View details of a specific student
* ✅ Update student details
* ✅ Delete a student
* ✅ Validations for blank names and valid marks (0–100)

---

### 📄 Project Structure

```
StudentManagementSystem/
│
├── com/
│   └── lohithpuvvala/
│       ├── Main.java        # Main driver class
│       └── Student.java     # Student data model class
│
└── README.md                # Project overview and setup instructions
```

---

### 🧑‍💻 How It Works

1. Run the `Main` class.
2. You’ll be shown a menu with 5 options:

    * Add Student
    * Update Student Details
    * Delete Student
    * View All Students
    * View Single Student
3. Enter the student details via the console.
4. Student details are stored in memory using `ArrayList` and `HashMap`.

---

### ✅ Input Validations

* Names **cannot be blank**
* Marks **must be between 0 and 100**
* Duplicate student IDs are not allowed

---

### 🚀 Getting Started

1. Clone or download the project:

   ```bash
   git clone https://github.com/lohithpuvvala/Student-Record-Management-System.git
   ```
2. Open the project in any Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run the `Main.java` file.

---

### 🧪 Sample Output

```
====== Welcome to the Student Management System ======
1. Add Student
2. Update Student Details
3. Delete Student
4. View All Students Details
5. View Student Details
```
---