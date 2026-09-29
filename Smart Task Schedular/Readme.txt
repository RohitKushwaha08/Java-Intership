 Smart Task Schedular

A simple Java desktop application that helps users create, organize, edit, complete, and manage tasks according to their priority.

 📌 Project Overview

Smart Task Schedular is a JavaFX-based task management application developed using Java.

The application allows users to:

* Add new tasks
* Set task priority
* Set deadlines
* View tasks according to priority
* Edit existing tasks
* Delete tasks
* Mark tasks as completed
* Automatically save tasks
* Load saved tasks when the application starts

The project uses a PriorityQueue to organize tasks based on their priority.

---

 ✨ Features

 1. Add Task

Users can enter:

* Task title
* Priority
* Deadline

Available priorities:

* High
* Medium
* Low

 2. Priority-Based Scheduling

Tasks are organized using Java's `PriorityQueue`.

The priority order is:

High
  ↓
Medium
  ↓
Low

High-priority tasks are handled before medium- and low-priority tasks.

 3. Edit Task

Users can select an existing task, modify its information, and save the changes.

 4. Delete Task

Users can select a task and permanently remove it from the task list.

 5. Complete Task

The application can mark the highest-priority task as completed and remove it from the active task list.

 6. Automatic Saving

Tasks are automatically stored in: tasks.txt


The application saves changes when tasks are:

* Added
* Edited
* Deleted
* Completed
* Saved manually
* When the application is closed

 7. Automatic Loading

Previously saved tasks are loaded automatically when the application starts.


 🛠️ Technologies Used

| Technology    | Purpose                        |
| ------------- | ------------------------------ |
| Java 26       | Main programming language      |
| JavaFX 27     | Graphical User Interface       |
| PriorityQueue | Priority-based task scheduling |
| ArrayList     | Temporary task sorting         |
| File I/O      | Saving and loading tasks       |
| VS Code       | Development environment        |

---

 📂 Project Structure

Smart Task Schedular/
│
├── SmartTaskGUI.java
├── SmartTaskSchedular.java
├── Task.java
├── SmartTaskSchedular.bat
└── tasks.txt


 File Description

SmartTaskGUI.java
Contains the JavaFX graphical interface and controls the main application functionality.

Task.java
Contains the task information such as title, priority, and deadline.

SmartTaskSchedular.java
Contains the earlier/main task scheduling logic used in the project.

SmartTaskSchedular.bat
Allows the application to be launched easily by double-clicking the file.

tasks.txt
Stores the saved task information.


💻 Requirements

Before running the application, install:

* Windows 10/11
* Java JDK 26
* JavaFX SDK 27
* VS Code or another Java IDE

 Java Version

Check your Java installation:

powershell
java --version


Example:
java 26.0.2.1

 JavaFX Location

This project uses JavaFX from:

D:\javafx-sdk-27\lib


If JavaFX is installed in another location, update the commands accordingly.


 ▶️ How to Run

 Method 1 — Easy Method

Double-click:
SmartTaskSchedular.bat


The application will open automatically.

 Method 2 — Using Terminal

Open PowerShell in the project folder.

Compile:

powershell
javac --module-path "D:\javafx-sdk-27\lib" --add-modules javafx.controls SmartTaskGUI.java Task.java

Run:

powershell
java --enable-native-access=javafx.graphics --module-path "D:\javafx-sdk-27\lib" --add-modules javafx.controls SmartTaskGUI


 🖥️ How to Use

 Add a Task

1. Enter the task title.
2. Select a priority.
3. Enter the deadline.
4. Click **Add Task**.

Example:

Task Title: Complete Java Project
Priority: High
Deadline: 30-09-2026


 Edit a Task

1. Click a task from the task list.
2. Its information appears in the input fields.
3. Change the required information.
4. Click **Edit Task**.

 Delete a Task

1. Select a task.
2. Click **Delete Task**.

 Complete a Task

Click:
Complete Task


The highest-priority task will be completed first.

 Save Tasks

Click:
Save Tasks


The current tasks will be stored in `tasks.txt`.



 🧠 Data Structure Used

 PriorityQueue

The project uses Java's `PriorityQueue` to organize tasks according to their priority.


High → Medium → Low


This allows important tasks to be handled before lower-priority tasks.

 ArrayList

An `ArrayList` is temporarily used when the task queue needs to be sorted for displaying tasks in the GUI.

---

## 💾 Data Storage

Tasks are stored in a simple text file:

tasks.txt


Each task stores:

Task Title | Priority | Deadline


Example:

Complete Java Project|High|30-09-2026
Study Java|Medium|01-10-2026
Play Games|Low|02-10-2026



## 🎯 Project Objective

The main objective of Smart Task Schedular is to create a simple task management application that demonstrates:

* Java programming
* Object-oriented programming
* JavaFX GUI development
* PriorityQueue
* File handling
* Task scheduling
* User interaction

---

## 🚀 Future Improvements

Possible future features include:

* Deadline reminders
* Automatic overdue-task detection
* Date picker for deadlines
* Search tasks
* Task categories
* Dark mode
* Notifications
* Task completion history
* Better GUI design
* Export tasks to PDF
* Database storage

---

## 👨‍💻 Author

Rohit Ramraj Kushwaha

Java Internship Project


## 📄 License

This project is created for educational and internship purposes.
