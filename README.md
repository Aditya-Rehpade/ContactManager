Simple Contact Manager
A lightweight Java Swing application to manage contacts with add, view, and delete functionality. Built for beginners with clean UI and no external dependencies.​

Features
✅ Add contacts (name required, phone/email optional)

✅ View all contacts in scrollable text area

✅ Delete selected contacts with confirmation

✅ Input validation and clear fields

✅ Responsive layout with proper spacing

✅ No database - in-memory storage (persists during session)

Tech Stack
text
• Java Swing (AWT/Swing components)
• Layout: BorderLayout + GridLayout
• Event Handling: ActionListener
• Collections: ArrayList<Contact>
Prerequisites
Java JDK 8+ (JDK 21/25 recommended)​

Any text editor or IDE (VS Code, IntelliJ, Eclipse)

Quick Setup (2 minutes)
bash
# 1. Create folder: ContactManager/
# 2. Save code as ContactManager.java
# 3. Open terminal in folder
# 4. Compile & Run:
javac ContactManager.java
java ContactManager
Window opens → Ready to use!​

File Structure
text
ContactManager/
├── ContactManager.java     # Main app + Contact class
├── README.md              # This file
└── screenshots/           # Add 4 PNG screenshots here
    ├── main-window.png
    ├── add-contact.png
    ├── contacts-list.png
    └── delete-success.png
Usage
Add: Fill name (required), phone, email → "Add Contact"

View: Contacts appear in scrollable area below

Delete: Click any contact line → "Delete Selected"

Clear: "Clear" empties input fields
