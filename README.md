# Five Chess (Gomoku) Game - Java Swing

A desktop-based Five Chess (Gomoku) game built with Java Swing. This project is a comprehensive implementation of Object-Oriented Programming (OOP) principles, featuring multiple board sizes, different game modes (Human vs. Computer, Human vs. Human), and multiple UI themes.

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Project Structure](#-project-structure)
- [OOP Concepts & Design](#-oop-concepts--design)
- [How to Run](#-how-to-run)
- [Screenshots](#-screenshots)
- [Technologies Used](#-technologies-used)
- [Author](#-author)

---

## 📖 Overview

This application allows users to play the classic board game Gomoku (Five in a Row). It includes a built-in AI for single-player mode, automatic win detection in all directions, and a fully customizable graphical interface. The software is designed with a focus on clean architecture, utilizing interfaces and the SOLID principles.

---

## ✨ Features

- ✅ **Multiple Board Sizes**: Standard (14x14), Improved (18x18), and Enlarged (22x22).
- ✅ **Two Game Modes**: 
  - **Human vs. Computer**: Play against an AI that calculates the best move based on the board state.
  - **Human vs. Human**: Play locally with a friend.
- ✅ **Interactive UI**: Place pieces by clicking on the board. Hover previews show where the piece will land.
- ✅ **Win Detection**: Automatically detects a sequence of 5 pieces in any direction (horizontal, vertical, diagonal).
- ✅ **Multiple UI Themes**: Switch between different Look and Feels (Metal, Motif, Windows).
- ✅ **Game Controls**: Restart the game or exit directly from the menu.
- ✅ **Help & About**: Version information accessible via the menu.

---

## 🗂 Project Structure

```text
BigHomework-FiveChess/
│
├── README.md
├── .gitignore
│
└── src/
    └── chess/
        ├── FiveChessAppletDemo.java  # Main entry point (Launcher)
        ├── ChessFrame.java           # Main window & Menu creation
        ├── MainPanel.java            # Board rendering & Mouse event handling
        ├── ChessModel.java           # Core game logic, AI, and Win detection
        └── ChessWindowEvent.java     # Custom WindowAdapter for closing the app
```

---

## 🧠 OOP Concepts & Design

This project heavily utilizes Object-Oriented Programming principles.

### 1. Interfaces & Polymorphism
- `ActionListener` is implemented by `ChessFrame` to handle menu actions (board size, themes, restart).
- `MouseListener` and `MouseMotionListener` are implemented by `MainPanel` to handle piece placement and hover previews.
- Polymorphism allows methods like `makeMenu` to accept different types of objects and process them dynamically.

### 2. Object Relationships (UML)
- **Dependency**: `ChessFrame` depends on `ChessModel` and `MainPanel`. `MainPanel` depends on `ChessModel`.
- **Association & Aggregation**: `ChessFrame` holds references to `ChessModel` and `MainPanel`, allowing communication between them.
- **Composition**: `ChessFrame` contains the Menu and Window components (their lifecycle is bound to the frame).
- **Inheritance**: 
  - `ChessFrame` extends `JFrame`.
  - `MainPanel` extends `JPanel`.
  - `ChessWindowEvent` extends `WindowAdapter`.

### 3. Design Patterns & Principles (SOLID)
- **Observer Pattern**: The GUI (View) reacts to user events using Listeners.
- **Strategy Pattern**: Game modes (Human vs. Computer, Human vs. Human) act as different strategies.
- **Single Responsibility Principle (SRP)**: Each class does one thing. `ChessFrame` (window/menu), `MainPanel` (drawing/UI), `ChessModel` (logic/AI).
- **Open-Closed Principle (OCP)**: The system is open for extension (new themes, new board sizes) without modifying core logic.
- **Interface Segregation Principle (ISP)**: Small interfaces like `MouseListener` ensure classes only implement methods they need.
- **Dependency Inversion Principle (DIP)**: The system relies on abstractions and interfaces rather than concrete implementations where possible.

---

## 🚀 How to Run

### Prerequisites

- **Java JDK 8** or higher.
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line.

### Steps via Command Line

1. **Clone the repository**
   ```bash
   git clone https://github.com/marCellacung/HW5-Five-Chess-Game.git
   cd HW5-Five-Chess-Game
   ```

2. **Compile the source code**
   ```bash
   javac -d out src/chess/*.java
   ```

3. **Run the application**
   ```bash
   java -cp out chess.FiveChessAppletDemo
   ```

### Using an IDE

1. Import the project as a Java project.
2. Mark `src` as the **source root**.
3. Run `FiveChessAppletDemo.java`.

---

## 📸 Screenshots

| Standard Board (14x14) | Improved Board (18x18) | Enlarged Board (22x22) |
| :---: | :---: | :---: |
| ![Standard](/image/14.png) | ![Improved](/image/18.png) | ![Enlarged](/image/22.png) |

| Theme 1 | Theme 2 | Theme 3 |
| :---: | :---: | :---: |
| ![Theme 1](/image/1.png) | ![Theme 2](/image/2.png) | ![Theme 3](/image/3.png) |

| Human vs. Computer |
| :---: |
| ![Computer Mode](/image/human-comp.png) |
---

## 🛠 Technologies Used

- **Java** — Core programming language.
- **Java Swing & AWT** — For building the GUI and handling events.
- **OOP Concepts** — Interfaces, Inheritance, Polymorphism.
- **SOLID Principles** — For clean and maintainable code architecture.

---

## 👤 Author

**MARCELLA**
- Institution: Shantou University
- Major: Data Science and Big Data Technology
- Email: 23marcella@stu.edu.cn

---

## 📄 License

This project is created for educational purposes as part of the Object-Oriented Programming Final Project.
