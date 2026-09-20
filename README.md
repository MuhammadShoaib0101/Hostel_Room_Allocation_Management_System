📌 Project Overview

Managing hostel room allocations manually is time-consuming and error-prone. Students need to be registered, rooms need to be tracked, and allocations must respect capacity limits — all while avoiding duplicates and conflicts.

Hostel Room Allocation System is a console-based Java application that provides a clean, object-oriented solution for managing students, rooms, and their allocations in a hostel environment.

The system allows an administrator to:

    Register students

    Add rooms with capacities

    Allocate students to rooms

    Deallocate students

    View all students, rooms, allocations, and system statistics

    🎯 The goal is to demonstrate Object-Oriented Programming, Collections Framework, and clean architecture in Java.

🎯 Problem It Solves
❌ The Problem

Manual hostel management faces several challenges:

    Rooms can be over-allocated if capacity isn't tracked

    Students can be assigned to multiple rooms by mistake

    Finding a student's room requires manual lookup

    No centralized way to view occupancy statistics

✅ The Solution

Hostel Room Allocation System provides a structured, rule-based allocation engine:
Feature	Description
✅ Duplicate Prevention	A student can only have one room at a time
✅ Capacity Enforcement	Rooms cannot exceed their maximum capacity
✅ Real-Time Stats	Live view of occupancy, availability, and totals
✅ Clean Lookups	Find students and rooms instantly by ID/number
👥 Target Users
🎓 University Hostel Administrators

Staff who need a simple tool to:

    Register incoming students

    Assign them to hostel rooms

    Track available seats

    Generate occupancy reports

👨‍💻 Java Learners

Students learning:

    OOP principles (Encapsulation, Abstraction)

    Java Collections (HashMap, ArrayList)

    Layered architecture (Model–Service–Manager)

✨ Main Features
1. 👤 Student Management

    Register students with ID, name, and department

    Prevent duplicate student IDs

    Search students by ID

    View all registered students with their assigned rooms

2. 🏠 Room Management

    Add rooms with a room number and capacity

    Prevent duplicate room numbers

    View all rooms with live occupancy status

3. 🔗 Room Allocation

    Allocate a student to a room (respects capacity)

    Prevent allocating a student who already has a room

    Deallocate a student and free up their seat

4. 📊 Allocation Overview

    View all current allocations (student → room)

    Clean tabular console output

5. 📈 System Statistics

Displays:

    Total Students

    Total Rooms

    Total Capacity

    Current Occupancy

    Available Seats

    Number of Allocated Students

6. 🎨 User-Friendly Console Menu

Interactive menu-driven interface with input validation for numeric fields.

⚙️ How The Application Works
text

       User
         │
         │  Selects Menu Option
         ▼
   Application.java
         │
         ▼
    Manager.java  ◄──── Central Controller
         │
    ┌────┼─────────────┬─────────────┐
    ▼    ▼             ▼             ▼
 Student  Room    Allocation     Statistics
  List    List     (Maps)         (Streams)
         │
         ▼
   Console Output

🏗️ Technical Architecture
🧩 Core Classes
Class	Responsibility
Application	Entry point, menu handling, user I/O
Manager	Central controller for students, rooms, allocations
Allocation	Manages student ↔ room relationships via maps
Student	Represents a student (ID, name, department, allocated room)
Room	Represents a room (number, capacity, occupants)
🔗 Relationship Map
text

  Manager
    ├── List<Student>
    ├── List<Room>
    └── Allocation
            ├── Map<Student, Room>
            └── Map<Room, List<Student>>

🛠️ Technologies Used
Category	Technology
Language	Java (JDK 14+ for switch arrow syntax)
Collections	ArrayList, HashMap, List, Map
Streams	Java Streams API (for statistics)
I/O	java.util.Scanner
Paradigm	Object-Oriented Programming
IDE	IntelliJ IDEA / Eclipse / VS Code

🚀 Running The Project Locally
1️⃣ Clone Repository
bash

git clone https://github.com/your-username/hostel-room-allocation-system.git

2️⃣ Navigate Into Project
bash

cd hostel-room-allocation-system

3️⃣ Compile All Java Files
bash

javac *.java

4️⃣ Run the Application
bash

java Application

🖥️ Usage Guide

On launch, the program loads sample data (2 students + 3 rooms) and shows:
text

===== HOSTEL ROOM ALLOCATION SYSTEM =====
1. Register Student
2. Add Room
3. Allocate Room
4. Deallocate Room
5. View Students
6. View Rooms
7. View Allocations
8. System Statistics
0. Exit

🔄 Typical Workflow

    Register new students → option 1

    Add hostel rooms → option 2

    Allocate students to rooms → option 3

    View students, rooms, or allocations → options 5, 6, 7

    Check stats any time → option 8

    Deallocate if a student leaves → option 4

🧪 Sample Session
text

Enter Choice: 3
Enter Student ID: S001
Enter Room Number: 101
Success: Student S001 allocated to Room #101

Enter Choice: 8

========== System Statistics ==========
Total Students     : 2
Total Rooms        : 3
Total Capacity     : 6
Current Occupancy  : 1
Available Seats    : 5
Allocated Students : 1
=======================================

📁 Project Structure
text

hostel-room-allocation-system/
│
├── Application.java     # Main entry point + CLI menu
├── Manager.java         # Central controller
├── Allocation.java      # Student ↔ Room mapping logic
├── Student.java         # Student model
├── Room.java            # Room model
├── rooms.java           # (Draft) earlier version — can be removed
├── students.java        # (Draft) earlier version — can be removed
├── Screenshots/         # UI screenshots
│   ├── main-menu.png
│   ├── students.png
│   ├── rooms.png
│   └── statistics.png
├── README.md            # Documentation
└── LICENSE              # MIT License

    💡 Note: rooms.java and students.java are early draft classes. The final versions are Room.java and Student.java.

🧪 Error Handling

The system gracefully handles common errors:
Scenario	System Response
Duplicate student ID	❌ Error: Student ID S001 already exists.
Duplicate room number	❌ Error: Room #101 already exists.
Room is full	❌ Error: Room #101 is full.
Student already has a room	❌ Error: Student S001 already has a room.
Non-existent student	❌ Error: Student S999 not found.
Non-existent room	❌ Error: Room #999 not found.
Invalid numeric input	⚠️ Please enter a valid number.
🔐 Design Principles Followed

    ✅ Single Responsibility — each class has one clear job

    ✅ Defensive Copying — getters return copies to prevent external mutation

    ✅ Encapsulation — all fields are private

    ✅ Delegation — Manager delegates to Allocation and models

    ✅ Clean Naming — descriptive class and method names

    ✅ Separation of Concerns — UI, logic, and data are separated

⚠️ Limitations

    ❌ No file persistence — data is lost when the program exits

    ❌ No database — everything is in-memory

    ❌ No login / authentication — single admin role

    ❌ No room type / gender restrictions

    ❌ No waiting list when rooms are full

    ⚠️ students.java and rooms.java are leftover drafts and should be removed

🔮 Future Improvements
💾 Data Persistence

    Save and load data using file I/O or SQLite

    Auto-save on exit and auto-load on startup

🔐 Authentication

    Admin login system

    Role-based access (Admin vs Warden)

🏠 Room Features

    Room types (Single, Double, Dorm)

    Gender-based allocation rules

    Floor / block tracking

📊 Reporting

    Export reports to CSV / PDF

    Monthly occupancy history

    Student allocation history

🖥️ GUI Version

    Build a JavaFX or Swing interface

    Optional web version using Spring Boot

🧪 Testing

    Add JUnit tests for Manager, Room, and Allocation

👨‍💻 Author

Muhammad Shoaib

    GitHub: @MuhammadShoaib0101

📄 Project Purpose

This project demonstrates the practical use of:

    🧠 Object-Oriented Programming (Encapsulation, Composition, Delegation)

    ☕ Java Collections Framework (HashMap, ArrayList)

    🌊 Java Streams API for statistics

    🏗️ Layered Architecture (UI → Manager → Allocation → Models)

    🎯 Clean Code principles

    It was developed as a learning project to build a realistic, rule-based hostel management system in Java.

<div align="center">

Made with ❤️ by Muhammad Shoaib
</div> ```
