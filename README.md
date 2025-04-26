<<<<<<< HEAD
Bank Account Management System
This is a simple Java-based Bank Account Management System that allows users to create accounts, deposit and withdraw funds, check account balances, and view transaction histories. The system supports three types of bank accounts: Savings, Current, and Business. The account management is handled through a console-based menu system.

Features
Create Account: Allows users to create a new bank account with specified details such as account number, account holder name, account type, and initial deposit.
Deposit: Enables users to deposit money into their account.
Withdraw: Allows users to withdraw money from their account, subject to overdraft limits for Current and Business accounts and sufficient balance for Savings accounts.
Check Balance: Allows users to check their current account balance.
View Transaction History: Users can view a detailed history of all their transactions (deposits and withdrawals).
Account Types
Savings: Requires a minimum balance of ₹1000 and does not allow overdraft.
Current/Business: Requires a minimum balance of ₹5000 and supports an overdraft limit of ₹10,000.
Requirements
Java 8 or later.
No external libraries are required as this project uses only standard Java collections.
How to Run
Clone the Repository:

bash
Copy
git clone https://github.com/your-username/bank-account-system.git
cd bank-account-system
Compile and Run: Use the following command to compile and run the project:

bash
Copy
javac BankAccount.java BankingSystem.java
java BankingSystem
Using the System: After running the program, you will be presented with a menu to perform various actions. Choose the options to interact with the bank system.

Menu Options
Create Account: Allows you to create a new account by providing account number, holder name, account type, and initial deposit.
Deposit: Allows you to deposit a specified amount into your account.
Withdraw: Allows you to withdraw money from your account. If it's a Savings account, the withdrawal cannot exceed the available balance. For Current and Business accounts, the withdrawal cannot exceed the overdraft limit.
Check Balance: Displays the current balance of the selected account.
View Transaction History: Displays the transaction history for the selected account.
Exit: Exits the system.
Example Usage
Creating an Account:

Enter Account Number: 12345
Enter Account Holder Name: John Doe
Enter Account Type (Savings, Current, Business): Savings
Enter Initial Deposit (Min ₹1000): 2000
Depositing Money:

Enter Account Number: 12345
Enter Amount: 1500
Withdrawing Money:

Enter Account Number: 12345
Enter Amount: 500
Code Structure
BankAccount.java: Defines the properties and methods related to an individual bank account, such as account number, holder, type, balance, and transaction history. It also includes methods for depositing, withdrawing, checking balance, and viewing transaction history.

BankingSystem.java: Contains the main logic for interacting with the user. It displays the menu, accepts user input, and calls the appropriate methods from the BankAccount class to perform actions.

Notes
The system assumes that the user enters valid inputs. Further input validation can be added to improve the robustness of the system.
The overdraft limit for Current and Business accounts is ₹10,000, which means the account can go into a negative balance up to ₹10,000.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contributions
Feel free to fork the repository and submit pull requests for improvements, bug fixes, or new features!

For any questions or issues, please feel free to open an issue in the repository.

Happy Banking! 😊
=======
# 🏦 Simple Banking System (Java)

This project is a **console-based Banking System** developed in **Java** using only **Arrays** and **Lists** (no database).  
It allows customers to **create accounts**, **deposit money**, **withdraw funds**, **check balances**, and **view transaction history** with proper **validation** and **exception handling**.

---

## ✨ Features
- Create accounts (Savings, Current, Business)
- Deposit money into account
- Withdraw money with balance validation:
  - ❌ No overdraft for Savings accounts
  - ✅ Overdraft up to ₹10,000 for Current/Business accounts
- Check account balance
- View transaction history
- Unique Account Number validation (Primary Key)
- Minimum balance enforcement:
  - ₹1000 for Savings
  - ₹5000 for Current/Business
- Proper exception handling for invalid inputs
- Maintains data using **Java Lists/Arrays**

---

## 📂 File Structure
```bash
├── Main.java
```
- `BankAccount` class: stores customer details and transactions
- `BankingSystem` class: handles the user interface and operations

---

## 🛠 Technologies Used
- Java
- Arrays & ArrayLists
- Exception Handling (try-catch)

---

## 🚀 How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/banking-system-java.git
   ```
2. Navigate to the project directory:
   ```bash
   cd banking-system-java
   ```
3. Compile and run:
   ```bash
   javac Main.java
   java BankingSystem
   ```

---

## 📸 Screenshots

| Create Account | Deposit | Withdraw | View Transactions |
|:--------------:|:-------:|:--------:|:-----------------:|
| ![Create Account](#) | ![Deposit](#) | ![Withdraw](#) | ![Transactions](#) |

*(Add screenshots if you want!)*

---

## 🧪 Test Cases
| Scenario | Expected Result |
|:---------|:----------------|
| Create savings account with ₹800 | ❌ Error: Minimum ₹1000 required |
| Withdraw ₹2000 from Savings with ₹1500 balance | ❌ Error: Insufficient funds |
| Withdraw ₹9000 from Current with ₹5000 balance | ✅ Allowed with overdraft |
| View transaction history | ✅ Show past deposits/withdrawals |

---

## 🎯 Future Improvements
- Add user authentication (login/logout)
- Interest calculation for Savings accounts
- GUI-based frontend (JavaFX / Swing)

---


## 🙌 Acknowledgments
- Inspired by real-world banking operations.
- Built for academic learning and Java practice!

>>>>>>> 50aaa41 (Readme Updated 26.04.25 10:30 PM)
