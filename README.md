[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# Random Password Generator using Java OOP

## Project Title
Random Password Generator using Java OOP

## Problem Statement
Weak and predictable passwords are a major security issue in today’s digital world. Many users still create simple passwords that are easy to guess. This project provides a Java-based password generator that creates strong and customizable passwords using uppercase letters, lowercase letters, numbers, and symbols. It also includes a secure mode for stronger password generation and allows saving generated passwords to a file.

## Target User
Students, general users, and anyone who wants secure password generation.

## Core Features
- Generate random passwords
- Select uppercase, lowercase, numbers, and symbols
- Secure mode for stronger passwords
- Copy password to clipboard
- Save password to file
- Input validation and error handling
- Java Swing GUI

## OOP Concepts Used
- Abstraction
- Encapsulation
- Inheritance
- Polymorphism
- Exception Handling

## Architecture Description
The project follows a modular package structure:
- `core` → Password generation logic
- `ui` → Graphical User Interface
- `util` → File handling utility

Main classes:
- `Generator`
- `PasswordGenerator`
- `SecurePasswordGenerator`
- `CharacterPool`
- `MainUI`
- `PasswordFileManager`

## How to Run

### Compile
```bash
javac src/com/passwordgen/core/*.java src/com/passwordgen/ui/*.java src/com/passwordgen/util/*.java